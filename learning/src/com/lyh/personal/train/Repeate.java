package com.lyh.personal.train;

import java.util.HashMap;
import java.util.Map;

/**
 * �ҳ�û���ظ�������
 * O(n)+O(resultMap.size)
 */
public class Repeate {

    public static void main(String[] args) {

        int[] t1 = {1, 22, 2, 2, 3, 5, 3, 3, 4, 4, 4, 4, 5, 22, 6};
        Map<Integer, Integer> m1 = new HashMap<Integer, Integer>();
        for (int v = 0, i = 0, size = t1.length; i < size; i++) {
            int temp = t1[i];
            if (i == 0) {
                v = temp;
                m1.put(v, 1);
                continue;
            }
            /**
             * ��ǰ��������Ԫ�ضԱȣ�
             * û���ҵ��ظ�����������ǲ��ظ��ģ�
             * ���������Map�У�<Ԫ��, ���ִ���>��
             * ������Ҫ����containsKey()����У�飻
             * ����ҵ����ظ��ģ��򽫶�Ӧ��Map��Key��Value+1��
             * ��󣬱��������
             */
            boolean repeat = (v == temp);
            if (!repeat) {
                if (!m1.containsKey(temp)) {
                    m1.put(temp, 1);
                }else{
                    repeat = true;
                }
                v = temp;
            }
            if (repeat){
                m1.put(v, m1.get(v) + 1);
            }


        }

        for (Map.Entry<Integer, Integer> t : m1.entrySet()) {
            System.out.println("-> " + t.getKey() + " : " + t.getValue());
        }

    }


}
