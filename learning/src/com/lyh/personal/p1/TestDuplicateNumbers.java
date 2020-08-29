package com.lyh.personal.p1;

public class TestDuplicateNumbers {

    public static  void main(String[] args){
        int[] a = {5, 4, 2, 1, 4, 3};
        int[] b = {2, 3, 1, 0, 2, 5};
        test(a);
        test(b);
    }

    /**
     * 题目：在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
     * 请找出数组中任意一个重复的数字。
     *
     * 解题思路：要求时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
     * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
     * @param a
     */
    public static void test(int[] a){
        if (a == null){return;}
        int size = a.length;
        if (size <= 0){return;}

        int i = 0;
        while (true){
            //  如果值与下标不相等，则将值放在相等的下标地址中
            // temp是值下标地址的旧值
            int v = a[i], temp = a[v];
            if (v != i){
                if (v == temp){
                    System.out.println("found num: " + a[i]);
                    return;
                }
                a[v] = v;
                // 先将旧值暂时存放在i地址下，等待下次判断
                a[i] = temp;
            }else if (size == ++i){return;}

        }

    }



}
