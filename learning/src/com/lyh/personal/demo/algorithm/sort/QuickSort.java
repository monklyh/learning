package com.lyh.personal.demo.algorithm.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] as = {5,3,9,6,4,8,7,2,10,1};
        long t = System.currentTimeMillis();
        sort(as);
        System.out.println(Arrays.toString(as) + " wateTime:" + (System.currentTimeMillis() - t));
   /*     int[] as2 = {5,3,9,6,4,8,7,2,10,1};
        long t2 = System.currentTimeMillis();
        Arrays.sort(as2);
        System.out.println(Arrays.toString(as) + " wateTime:" + (System.currentTimeMillis() - t2));*/


    }

    /**
     * 从左往右递增
     * @param as
     */
    public static void sort(int[] as){
        sort(as, 0, as.length - 1);
    }

    /**
     * 从左往右递增
     * @param as
     */
    private static void sort(int[] as, int l, int r){
        if (l >= r){
            return;
        }
        int begin = l;
        int end = r;
        // 选择标准数
        int temp = as[l];
        while (l < r){
            // 先从右边开始找比标准数小的
            if (as[r] < temp){
                // 再从左边开始找比标准数大的
                if (as[l] > temp){
                    int t = as[l];
                    as[l] = as[r];
                    as[r] = t;
                    continue;
                }
                l++;
                continue;
            }
            r--;
        }
        // 此时l=r，将标准数放入此位置（左边的都小于它，右边的都大于它）
        as[begin] = as[l];
        as[l] = temp;

        // 递归排序左区域
        sort(as, begin, l - 1);

        // 递归排序右区域
        sort(as, l + 1, end);

    }


}
