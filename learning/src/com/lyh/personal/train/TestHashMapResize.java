package com.lyh.personal.train;

public class TestHashMapResize {

    public static void main(String[] args) {
       /* HashMap<TestHashCoder, String> m = new HashMap<>(8);
        for (int i = 1; i < 100; i++){
            for (int j = 0; j < 7; j++){
                m.put(new TestHashCoder(i), i + "_" + j);
            }
        }*/

        Node[] ns = new Node[3];
        Node h = new Node(1);
        ns[0] = h;
        for (int i = 2; i < 4; i++){
            Node t = new Node(i);
            h.next = t;
            h = t;
        }

        // 模拟jdk1.7 HashMap扩容时的头插法
        Node nh = ns[0];
        while (null != nh){
            Node next = nh.next;
            nh.next = ns[2];
            ns[2] = nh;
            nh = next;
        }

    }

    public static class Node{
        Node next;
        int v;
        public Node(int v){
            this.v = v ;
            next = null;
        }
    }

    public static class TestHashCoder{
        int v;
        TestHashCoder(int v){
            this.v = v;
        }

        @Override
        public int hashCode() {
            return v;
        }
    }
}
