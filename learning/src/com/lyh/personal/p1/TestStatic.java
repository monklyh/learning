package com.lyh.personal.p1;

public class TestStatic {
    private static int x=100;
    public static void main(String args[]){
        TestStatic hs1=new TestStatic();
        hs1.x++;
        TestStatic  hs2=new TestStatic();
        hs2.x++;
        hs1=new TestStatic();
        hs1.x++;
        TestStatic.x--;
        System.out.println("x="+x);
    }
}
