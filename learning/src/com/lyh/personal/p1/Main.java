package com.lyh.personal.p1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        changeHex();
    }

    public static void changeHex(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            if (str.contains("0x")){
                str = str.replaceFirst("0x", "");
            }
            int result = 0;
            int hexCount = 0;
            for (int i = str.length()-1; i >= 0; i--){
                char temp = str.charAt(i);
                if (i == str.length()-1){
                    hexCount = 1;
                }else {
                    hexCount*=16;
                }
                int tempInt;
                if (temp >= 'A' && temp <= 'F'){
                    tempInt = temp - 'A' + 10;
                }else if (temp >= 'a' && temp <= 'f'){
                    tempInt = temp - 'a' + 10;
                } else {
                    tempInt = temp - '0';
                }
                tempInt *= hexCount;
                result += tempInt;
            }
            System.out.println(result);
        }

    }

    public static void unDeduplicationNums2(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

            int num = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i = 0 ; i < num ;i++){
                int curr = sc.nextInt();
                set.add(curr);
            }
            for(Integer i : set){
                System.out.println(i);
            }
        }
    }

    public static void unDeduplicationNums(){
        boolean isInputing = false;
        Set<Integer> nums = new HashSet<>();
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String numStr = sc.nextLine();
            if (!isInputing){
                try {
                    counter = Integer.parseInt(numStr);
//                    System.out.println("请开始输入"+numStr+"个整数，每个按回车结束");
                    isInputing = true;
                } catch (NumberFormatException e) {
//                    System.out.println("输入的格式不对，请重新输入");
                }
            }else{
                try {
                    nums.add(Integer.parseInt(numStr));
                } catch (Exception e) {
//                    System.out.println("输入的格式不对，请重新输入");
                    continue;
                }
                counter--;
                if (counter == 0){
                    Integer[] tempArray = nums.toArray(new Integer[0]);
                    Arrays.sort(tempArray);
                    for (Integer tempNum : tempArray){
                        System.out.println(tempNum);
                    }
                    nums.clear();
                    isInputing = false;
                }
            }

        }
    }



    public static void main_wordSize(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
//            String temps = sc.nextLine();
//            String[] tempsArray = temps.trim().split(" ");
//            System.out.println(tempsArray[tempsArray.length - 1].length());
            System.out.println(getLastWordSize(sc.nextLine()));
        }
    }

    public static int getLastWordSize(String words){

        boolean isContainsSpace = false;
        for (int i = words.length()-1, index = 0; i >= 0; i--){
            char temp = words.charAt(i);
            if (temp == ' ' && !isContainsSpace){
                isContainsSpace = true;
            }
            if (temp != ' ' && index == 0){
                index = i;
            }
            if (index > 0 && i < index && temp == ' '){
                return index - i;
            }
        }
        if (!isContainsSpace){
            return words.length();
        }
        return -1;
    }


}
