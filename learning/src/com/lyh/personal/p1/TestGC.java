package com.lyh.personal.p1;

public class TestGC {

    class A{
        public A(){
            System.out.println("A()");
        }

        public void say(){
            System.out.println("A say!");
        }

        @Override
        public void finalize(){
            System.out.println("A: final");
        }
    }

    class B extends A{
        public B(){
            System.out.println("B()");
        }

        public void say(){
            System.out.println("B say!");
        }

        @Override
        public void finalize(){
            System.out.println("B: final");
        }
    }


    public static void main(String[] args){
        TestGC t = new TestGC();
        A a = t.new B();
        a.say();
        a = null;
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
