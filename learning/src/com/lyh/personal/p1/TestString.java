package com.lyh.personal.p1;

public class TestString {

    public static  void main(String[] args){
        String v1 = "hello";
        String v2 = "he" + new String("llo");
        System.out.println(v1 == v2);

        String s = "i am bunny.";
        String[] ts = s.split(" ");
        for (int i = ts.length - 1; i >= 0; i--){
            System.out.print(ts[i]);
            if (i == 0)break;
            System.out.print(" ");
        }
    }

}
