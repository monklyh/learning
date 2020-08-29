package com.lyh.personal.train;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出没有重复的数据
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
             * 从前到后，相邻元素对比；
             * 没有找到重复的情况，则都是不重复的；
             * 将结果放在Map中：<元素, 出现次数>；
             * ！！主要是用containsKey()方法校验；
             * 如果找到了重复的，则将对应的Map中Key的Value+1；
             * 最后，遍历结果。
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
