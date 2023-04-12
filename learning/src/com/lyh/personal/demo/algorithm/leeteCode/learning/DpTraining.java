package com.lyh.personal.demo.algorithm.leeteCode.learning;

/**
 * 动态规划算法
 * 动态规划（英语：Dynamic programming，简称 DP）是一种在数学、管理科学、计算机科学、经济学和生物信息学中使用的，
 * 通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法。
 * 动态规划常常适用于有重叠子问题和最优子结构性质的问题，并且记录所有子问题的结果，因此动态规划方法所耗时间往往远少于朴素解法。
 * 动态规划有自底向上和自顶向下两种解决问题的方式。自顶向下即记忆化递归，自底向上就是递推。
 * 使用动态规划解决的问题有个明显的特点，一旦一个子问题的求解得到结果，以后的计算过程就不会修改它，
 * 这样的特点叫做无后效性，求解问题的过程形成了一张有向无环图。动态规划只解决每个子问题一次，具有天然剪枝的功能，从而减少计算量。
 */
public class DpTraining {

    /**
     * 最大回文子串：
     * 对于一个子串而言，如果它是回文串，并且长度大于2，那么将它首尾的两个字母去除之后，它仍然是个回文串。例如对于字符串
     * “ababa”，如果我们已经知道
     * “bab” 是回文串，那么 “ababa” 一定是回文串，这是因为它的首尾两个字母都是 “a”。
     * 根据这样的思路，我们就可以用动态规划的方法解决本题。我们用 P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串（下文表示成 s[i:j]）是否为回文串：
     * P(i,j)=
     * {
     * true, 如果子串s[i:j]是回文串
     * false, 其它情况（包含两种可能性）：s[i,j] 本身不是一个回文串；i>j，此时 s[i,j] 本身不合法。
     * ​}
     * 那么我们就可以写出动态规划的状态转移方程：
     * P(i,j)=P(i+1,j−1)∧(Si==Sj)
     *
     * 也就是说，只有s[i+1:j−1] 是回文串，并且 s 的第 i 和 j 个字母相同时，s[i:j] 才会是回文串。
     * 上文的所有讨论是建立在子串长度大于2 的前提之上的，我们还需要考虑动态规划中的边界条件，即子串的长度为 1 或 2。
     * 对于长度为 1 的子串，它显然是个回文串；对于长度为 2 的子串，只要它的两个字母相同，它就是一个回文串。
     * 因此我们就可以写出动态规划的边界条件：
     * P(i,i)=true
     * P(i,i+1)=(Si==Si+1)
     * ​
     * 根据这个思路，我们就可以完成动态规划了，最终的答案即为所有 P(i,j)=true 中 j−i+1（即子串长度）的最大值。
     * 注意：在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的，因此一定要注意动态规划的循环顺序。
     * @param s
     */
    static String longestPalindrome(String s){
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 中心扩展法
     *
     * 我们仔细观察一下方法一中的状态转移方程：
     * P(i,i) = true
     * P(i,i+1) = (Si==Si+1)
     * P(i,j) = P(i+1,j−1)∧(Si==Sj)
     *
     * 找出其中的状态转移链：
     * P(i,j)←P(i+1,j−1)←P(i+2,j−2)←...←某一边界情况
     *
     * 可以发现，所有的状态在转移的时候的可能性都是唯一的。也就是说，我们可以从每一种边界情况开始「扩展」，也可以得出所有的状态对应的答案。
     * 边界情况即为子串长度为 1 或 2 的情况。我们枚举每一种边界情况，并从对应的子串开始不断地向两边扩展。如果两边的字母相同，我们就可以继续扩展，例如从
     * P(i+1,j−1) 扩展到 P(i,j)；如果两边的字母不同，我们就可以停止扩展，因为在这之后的子串都不能是回文串了。
     * 聪明的读者此时应该可以发现，「边界情况」对应的子串实际上就是我们「扩展」出的回文串的「回文中心」。
     * 方法的本质即为：我们枚举所有的「回文中心」并尝试「扩展」，直到无法扩展为止，此时的回文串长度即为此「回文中心」下的最长回文串长度。
     * 我们对所有的长度求出最大值，即可得到最终的答案。
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩展
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }



    /**
     * 斐波那契数列，求第n个数
     * F(0)=0, F(1)=1;
     * F(n) = F(n-2)+F(n-1);
     *
     * 此递归方法会有很大的重复计算
     * @param n
     * @return
     */
    static long fib(int n){
        if (n == 0 || n == 1){return n;}
        return (fib(n - 1) + fib(n - 2));
    }

    static long fib2(int n, long[] ns){
        if (n == 0){
            return 0;
        }
        if (ns == null){
            ns = new long[n+1];
            ns[0] = 0L;
            ns[1] = 1L;
        }

        if (ns[n] == 0){
            ns[n] = (fib2(n-2, ns) + fib2(n-1, ns))%1000000007;
        }

        return ns[n];
    }

    /**
     * 动态规划解析：
     * 状态定义： 设 dp 为一维数组，其中dp[i] 的值代表 斐波那契数列第 i 个数字 。
     * 转移方程： dp[i+1]=dp[i]+dp[i−1] ，即对应数列定义 f(n+1)=f(n)+f(n−1) ；
     * 初始状态： dp[0]=0, dp[1]=1 ，即初始化前两个数字；
     * 返回值： dp[n] ，即斐波那契数列的第 n 个数字。
     * @param n
     * @return
     */
    static int fib2(int n){
        int a = 1, b = 0, sum = 0;
        for (int i = 1; i < n; i++){
            sum = (a + b)%1000000007;
            b = a;
            a = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        long a = fib2(95);
        System.out.println(a + "--" + (System.currentTimeMillis()-t));
    }
}
