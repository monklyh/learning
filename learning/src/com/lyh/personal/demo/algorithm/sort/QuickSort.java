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
     * �������ҵ���
     * @param as
     */
    public static void sort(int[] as){
        sort(as, 0, as.length - 1);
    }

    /**
     * �������ҵ���
     * @param as
     */
    private static void sort(int[] as, int l, int r){
        if (l >= r){
            return;
        }
        int begin = l;
        int end = r;
        // ѡ���׼��
        int temp = as[l];
        while (l < r){
            // �ȴ��ұ߿�ʼ�ұȱ�׼��С��
            if (as[r] < temp){
                // �ٴ���߿�ʼ�ұȱ�׼�����
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
        // ��ʱl=r������׼�������λ�ã���ߵĶ�С�������ұߵĶ���������
        as[begin] = as[l];
        as[l] = temp;

        // �ݹ�����������
        sort(as, begin, l - 1);

        // �ݹ�����������
        sort(as, l + 1, end);

    }


}
