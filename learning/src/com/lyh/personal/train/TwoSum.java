package com.lyh.personal.train;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出和为某个数的两个加数的位置
 */
public class TwoSum {

    public static  void main(String[] args){

        int[] ns = {2, 7, 11, 15};
        int target = 9;
        System.out.print(twoSum(ns,target)[0] + "," + twoSum(ns,target)[1] );

    }

    public static int[] twoSum(int[] ns, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0, size=ns.length; i < size; i++){
            int temp = target - ns[i];
            if(map.containsKey(temp)){
                result[1] = i + 1;
                result[0] = map.get(temp);
                return  result;
            }
            map.put(ns[i], i + 1);
        }
        return result;
    }

}
