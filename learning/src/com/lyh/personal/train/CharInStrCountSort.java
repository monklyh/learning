package com.lyh.personal.train;

import java.util.ArrayList;
import java.util.Scanner;

public class CharInStrCountSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String str = in.nextLine();
            if (str.length() > 1000000){
                System.out.println("the string over length");
                continue;
            }
//            countA(str);
            printStr(str);
        }

    }


    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param str
     */
    public static void countA(String str){
        int length = str.length();
        int halfLength = length/2;
        int countA = 0;
        for (int i = 0, j = halfLength; i < halfLength || j < length; i++,j++){
            if (i < halfLength){
                char c1 = str.charAt(i);
                if (c1 == 'a'){
                    countA++;
                }
            }
            if (j < length){
                char c2 = str.charAt(j);
                if (c2 == 'a'){
                    countA++;
                }
            }
        }
        System.out.println(countA);
    }


    public static class CharCounter{
        int index = -1;
        int count = 0;
        String c;
        public CharCounter(String c, int index){
            this.c = c;
            this.index = index;
            this.countAdd();
        }
        public void countAdd(){
            this.count++;
        }


        public static void countTheChar(CharCounter[] charList,
                                        char cc1, int index){
            CharCounter charCounter = charList[index];
            if (charCounter != null){
                charCounter.countAdd();
            }else{
                String c1 = String.valueOf(cc1);
                CharCounter c = new CharCounter(c1, index);
                charList[index] = c;
            }
        }


        public static void swap(CharCounter[] charCounters, int c1, int c2){
            CharCounter temp = charCounters[c1];
            charCounters[c1] = charCounters[c2];
            charCounters[c2] = temp;

        }

        public static void swap(ArrayList<CharCounter> charCounters, int c1, int c2){
            CharCounter temp = charCounters.get(c1);
            charCounters.set(c1, charCounters.get(c2));
            charCounters.set(c2, temp);
        }


        @Override
        public String toString(){
            return this.c + "-count:" + this.count + " -index:" + this.index + "\r\n";
        }

        public void print(){
            for (int i = 0; i < this.count; i++){
                System.out.print(this.c);
            }
        }
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param str
     */
    public static void findMaxExist(String str){

        CharCounter[] charCounters = new CharCounter[26];
        int length = str.length();
        int halfLength = length/2;

        for (int i = 0, j = halfLength; i < halfLength || j < length; i++,j++){
            if (i < halfLength){
                char cc1 = str.charAt(i);
                CharCounter.countTheChar(charCounters, cc1, cc1 - 'a');
            }
            if (j < length){
                char cc2 = str.charAt(j);
                CharCounter.countTheChar(charCounters, cc2, cc2 - 'a');
            }
        }


        CharCounter r = null;
        for (CharCounter c : charCounters) {
            if (c != null){
                if (r == null){
                    r = c;
                }else{
                    if (c.count > r.count){
                        r = c;
                    }else if (c.count == r.count && c.index < r.index){
                        r = c;
                    }
                }

            }
        }
        System.out.println(r.c);

    }


    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param str
     */
    public static void printStr(String str){

        CharCounter[] charCounters = new CharCounter[26];
        int length = str.length();
        int halfLength = length/2;

        for (int i = 0, j = halfLength; i < halfLength || j < length; i++,j++){
            if (i < halfLength){
                char cc1 = str.charAt(i);
                CharCounter.countTheChar(charCounters, cc1, cc1 - 'a');
            }
            if (j < length){
                char cc2 = str.charAt(j);
                CharCounter.countTheChar(charCounters, cc2, cc2 - 'a');
            }
        }

        ArrayList<CharCounter> charCountList = new ArrayList<>();
        for (CharCounter c : charCounters){
            if (c != null){
                charCountList.add(c);
            }
        }

        for (int i = 0, size = charCountList.size()-1; i < size; i++){

            for (int j = size - i; j >= 1; j--){
                CharCounter tempCharj = charCountList.get(j);
                CharCounter tempCharjp = charCountList.get(j-1);
                if (tempCharj.count > tempCharjp.count){
                    CharCounter.swap(charCountList, j, j-1);
                }

            }
        }

        for (CharCounter c : charCountList) {
            if (c != null){
                c.print();
            }
        }


    }

}
