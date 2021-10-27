package com.lyh.personal.train;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        checkTimeFirst();
    }

    public static void sortString(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            List<String> list = new ArrayList<>();
            for (int i = 1, size = strs.length; i < size; i++){
                String s = strs[i];
                while (s.length() > 8){
                    String s2 = s.substring(8);
                    String s1 = s.substring(0, 8);
                    list.add(s1);
                    if (s2.length() > 8){
                        s = s2;
                        continue;
                    }else{
                        addStr(s2, list);
                        break;
                    }
                }
                if (s.length() <= 8){
                    addStr(s, list);
                }

            }
            Collections.sort(list);
            for (String s : list){
                System.out.print(s + " ");
            }
        }
    }

    private static void addStr(String s2, List<String> list){
        char[] c = new char[8];
        for (int j = 0; j < 8; j++){
            if (j < s2.length()){
                c[j] = s2.charAt(j);
            }else{
                c[j] = '0';
            }
        }
        list.add(new String(c));
    }


    public static void checkTimeFirst(){
        Scanner sc = new Scanner(System.in);
//        String secondsCompare = "";
        String msCompare = "";
        int firstCount = 0;

        while (sc.hasNextLine()){
            String tempTime = sc.nextLine();
            if (tempTime.isEmpty()){
                System.out.println(firstCount);
                firstCount = 0;
//                secondsCompare = "";
                msCompare = "";
                continue;
            }
            // 假设数据都是一秒内的
            /*String seondsTime = tempTime.substring(0, tempTime.lastIndexOf("."));
            if (!seondsTime.equals(secondsCompare)){
                secondsCompare = seondsTime;
                msCompare = ms;
                firstCount = 1;
            }else{

            }*/
            String ms = tempTime.substring(tempTime.lastIndexOf(".") + 1);
            if (!msCompare.equals(ms)){
                if (msCompare.isEmpty()){
                    msCompare = ms;
                    firstCount = 1;
                    continue;
                }
                int tempMsCompare = Integer.parseInt(msCompare);
                int tempMs = Integer.parseInt(ms);
                if (tempMsCompare > tempMs){
                    if (firstCount > 1){
                        firstCount = 1;
                    }
                    msCompare = tempMs + "";
                }
            } else {
                firstCount++;
            }
        }


    }

}

