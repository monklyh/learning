package com.lyh.personal.demo.algorithm.leeteCode.learning;

public class Solution {

    /**
     * 存在一种仅支持 4 种操作和 1 个变量 X 的编程语言：
     *
     * ++X 和 X++ 使变量 X 的值 加 1
     * --X 和 X-- 使变量 X 的值 减 1
     * 最初，X 的值是 0
     *
     * 给你一个字符串数组 operations ，这是由操作组成的一个列表，返回执行所有操作后， X 的 最终值 。
     *
     * 提示：
     * 1 <= operations.length <= 100
     * operations[i] 将会是 "++X"、"X++"、"--X" 或 "X--"
     *
     * 链接：https://leetcode.cn/problems/final-value-of-variable-after-performing-operations
     * @param operations
     * @return
     */
    public int finalValueAfterOperations(String[] operations) {

        if (operations == null || operations.length == 0){return 0;}
        int x = 0;
        for (String oper : operations){
            if (null == oper || "".equals(oper)){continue;}
            if (oper.contains("++")){
                x++;
            }else if (oper.contains("--")){
                x--;
            }
        }
        return x;

    }


    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * 提示：
     * 1 <= s.length <= 104
     * s 仅由括号 '()[]{}' 组成
     *
     * 链接：https://leetcode.cn/problems/valid-parentheses
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (null == s || "".equals(s)){return false;}
        int len = s.length();
        if (len % 2 > 0){return false;}
        int count = 0;
        int[] larr = new int[len];
        int bi = 0;
        for (int i = 0; i < len; i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                count++;
                if (count > 1){bi++;}
                larr[bi] = c;
            }else if (c == ')' || c == '}' || c == ']'){
                int d = c - larr[bi];
                larr[bi] = 0;
                if (count > 1){bi--;}
                if (d > 0 && d < 3){
                    count--;
                    if (count < 0){return false;}
                }else{
                    return false;
                }
            }
        }
        return  count <= 0;
    }

    public static boolean isValid2(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 != 0 ) {
            return false;
        }
        char[] chars = new char[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char cha = s.charAt(i);
            if (cha == '(' || cha == '[' || cha == '{') {
                chars[count++] = cha == '(' ? ')' : cha == '[' ? ']' : '}';
            } else {
                if (count == 0) {
                    return false;
                }
                if (chars[--count] != cha) {
                    return false;
                }
            }
        }
        return count == 0;
    }


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     * 提示:
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为 无重复元素 的 升序 排列数组
     * -104 <= target <= 104
     *
     * 链接：https://leetcode.cn/problems/search-insert-position
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (num < target){
                if (i == nums.length-1){
                    return i+1;
                }
            }else{
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println((int)'[' + "->" + (int)']');
        System.out.println((int)'{' + "->" + (int)'}');
        System.out.println((int)'(' + "->" + (int)')');

        System.out.println(isValid2("([{}{}}{])"));
    }
}
