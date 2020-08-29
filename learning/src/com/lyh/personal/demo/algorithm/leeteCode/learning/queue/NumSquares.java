package com.lyh.personal.demo.algorithm.leeteCode.learning.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 完全平方数:
 * 给定正整数?n，找到若干个完全平方数（比如?1, 4, 9, 16, ...）使得它们的和等于 n。
 * 你需要让组成和的完全平方数的个数最少。
 *
 * 示例?1:
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 *
 * 示例 2:
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(numSquaresBFS(12));
    }

    /**
     * 1，对于正整数N, 所有的解都是 N = 一个整数的平方 + 另一个整数; 直白点, N = AxA + B
     * 2, 而B又是由 "一个整数的平方 + 另一个整数" 组成的; 那么, B = CxC + D
     * 3，总结下就是：N = |x| + N' 而 N' = |x| + N''
     * 4, 本题要解的问题：正整数N最少由多个平方数相加;
     * 5, 那么，N的最优解 = 1 + （N’的最优解）。而N'肯定小于N。
     * 6, 所以本题的思路就是，对每一个N，观察1到N-1中，谁的解最小，那么N的解就是它+1.
     * 7, 但是我们没必要1到N+1中的每一个数都去观察，因为有些组合不满足N = |x| + N'，
     *    譬如12 = 2+N'是不需要的，因为2不是某个数的平方。所以我们观察的范围要大大减小。
     *
     * 拿12举例,我们只能观察：
     * 12 = 1 + 11
     * 12 = 4 + 8
     * 12 = 9 + 3
     * 我们要得出3，8，11中谁的解最优，那么12的解就是它+1。
     * 我们从1到N计算, 2的解从1里找，3的解从[2,1]里找，4的解从[3,2,1]里找，依次类推，最后算到N的解即可。
     */

    /**
     * 动态规划
     * 时间复杂度：O(n*sqrt(n))，sqrt为平方根
     * @param n
     * @return
     */
    public int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        //依次求出 1, 2... 直到 n 的解，并放入对应下标位置中
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            //依次减去一个平方数
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * 广度优先
     * 一层一层的算。第一层依次减去一个平方数得到第二层，
     * 第二层依次减去一个平方数得到第三层。
     * 直到某一层出现了 0，此时的层数就是我们要找到平方数和的最小个数。
     * @param n
     * @return
     */
    public static int numSquaresBFS(int n) {
        Queue<Integer> queue=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level = 0;

        while(!queue.isEmpty()){
            level++;
            int len = queue.size();
            for(int i = 0; i < len; i++){
                int cur = queue.poll();

                for(int j=1; j*j <= cur; j++){
                    int tmp = cur - j*j;
                    if(tmp == 0){
                        return level;
                    }
                    if(!visited.contains(tmp)){
                        queue.offer(tmp);
                        visited.add(tmp);
                    }
                }
            }
        }
        return level;

    }
}
