package com.lyh.personal.demo.algorithm.leeteCode.learning.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ȫƽ����:
 * ����������?n���ҵ����ɸ���ȫƽ����������?1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n��
 * ����Ҫ����ɺ͵���ȫƽ�����ĸ������١�
 *
 * ʾ��?1:
 * ����: n = 12
 * ���: 3
 * ����: 12 = 4 + 4 + 4.
 *
 * ʾ�� 2:
 * ����: n = 13
 * ���: 2
 * ����: 13 = 4 + 9.
 */
public class NumSquares {

    public static void main(String[] args) {
        System.out.println(numSquaresBFS(12));
    }

    /**
     * 1������������N, ���еĽⶼ�� N = һ��������ƽ�� + ��һ������; ֱ�׵�, N = AxA + B
     * 2, ��B������ "һ��������ƽ�� + ��һ������" ��ɵ�; ��ô, B = CxC + D
     * 3���ܽ��¾��ǣ�N = |x| + N' �� N' = |x| + N''
     * 4, ����Ҫ������⣺������N�����ɶ��ƽ�������;
     * 5, ��ô��N�����Ž� = 1 + ��N�������Ž⣩����N'�϶�С��N��
     * 6, ���Ա����˼·���ǣ���ÿһ��N���۲�1��N-1�У�˭�Ľ���С����ôN�Ľ������+1.
     * 7, ��������û��Ҫ1��N+1�е�ÿһ������ȥ�۲죬��Ϊ��Щ��ϲ�����N = |x| + N'��
     *    Ʃ��12 = 2+N'�ǲ���Ҫ�ģ���Ϊ2����ĳ������ƽ�����������ǹ۲�ķ�ΧҪ����С��
     *
     * ��12����,����ֻ�ܹ۲죺
     * 12 = 1 + 11
     * 12 = 4 + 8
     * 12 = 9 + 3
     * ����Ҫ�ó�3��8��11��˭�Ľ����ţ���ô12�Ľ������+1��
     * ���Ǵ�1��N����, 2�Ľ��1���ң�3�Ľ��[2,1]���ң�4�Ľ��[3,2,1]���ң��������ƣ�����㵽N�Ľ⼴�ɡ�
     */

    /**
     * ��̬�滮
     * ʱ�临�Ӷȣ�O(n*sqrt(n))��sqrtΪƽ����
     * @param n
     * @return
     */
    public int numSquaresDP(int n) {
        int[] dp = new int[n + 1];
        //������� 1, 2... ֱ�� n �Ľ⣬�������Ӧ�±�λ����
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            //���μ�ȥһ��ƽ����
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    /**
     * �������
     * һ��һ����㡣��һ�����μ�ȥһ��ƽ�����õ��ڶ��㣬
     * �ڶ������μ�ȥһ��ƽ�����õ������㡣
     * ֱ��ĳһ������� 0����ʱ�Ĳ�����������Ҫ�ҵ�ƽ�����͵���С������
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
