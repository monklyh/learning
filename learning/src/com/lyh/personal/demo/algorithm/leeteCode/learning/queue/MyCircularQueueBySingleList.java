package com.lyh.personal.demo.algorithm.leeteCode.learning.queue;

/**
 * 单链表实现的循环队列
 * 时间复杂度：O(1)
 * 空间复杂度：O(n)
 * @author monklyh
 */
public class MyCircularQueueBySingleList {

    class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }

    private int capacity;
    private int count;
    private Node head, tail;

    public MyCircularQueueBySingleList(int capacity){
        this.capacity = capacity;
        this.count = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.isFull()){
            return false;
        }

        Node newNode = new Node(value);
        if (this.count == 0){
            this.head = this.tail = newNode;
        }else{
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.isEmpty()){
            return false;
        }
        this.count--;
        this.head = this.head.next;

        return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if (this.isEmpty()){
            return -1;
        }
        return this.head.value;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.isEmpty()){
            return -1;
        }
        return this.tail.value;
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.count == this.capacity;
    }


    public static void main(String[] args) {
        test1();
    }


    public static void test1(){
        MyCircularQueueBySingleList circularQueue = new MyCircularQueueBySingleList(3);
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);

        // 返回 false，队列已满
        System.out.println("full-enQueue-f:" + circularQueue.enQueue(4));

        // 返回 3
        System.out.println("rear-3:" + circularQueue.Rear());

        // 返回 true
        System.out.println("isFull-t:" + circularQueue.isFull());
        // 返回 true
        System.out.println("deQueue-t:" + circularQueue.deQueue());

        // 返回 true
        System.out.println("enQueue-t:" + circularQueue.enQueue(4));

        // 返回 true
        System.out.println("deQueue-t:" + circularQueue.deQueue());
    }


}
