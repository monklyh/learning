package com.lyh.personal.demo.algorithm.leeteCode.learning;

import java.util.HashMap;

public class SolutionM {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 提示：
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     *
     * 思路：
     * 这道题主要用到思路是：滑动窗口
     * 什么是滑动窗口？
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     * 如何移动？
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     *
     * 时间复杂度：
     * O(n)
     *
     * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2){return len;}
        int ret = 0;
        StringBuilder maxStr = new StringBuilder();
        for (int i = 0; i <= len; i++){
            String c = (i == len ? s.charAt(i-1) : s.charAt(i))+"";
            if (maxStr.toString().contains(c)){
                int index = maxStr.lastIndexOf(c);
                ret = Math.max(ret, maxStr.length());
                if (index == 0){
                    maxStr.deleteCharAt(0);
                }else if (index == maxStr.length()-1){
                    maxStr = new StringBuilder();
                }else {
                    maxStr.delete(0, index+1);
                }
            }
            if (i < len){
                maxStr.append(c);
            }
        }
        return Math.max(ret, maxStr.length());
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) {return 0;}
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("ckilbkd"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb1234"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("bbbbb"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
