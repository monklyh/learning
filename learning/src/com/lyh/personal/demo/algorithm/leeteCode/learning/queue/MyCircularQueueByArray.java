package com.lyh.personal.demo.algorithm.leeteCode.learning.queue;

/**
 * 简单数组实现的循环队列
 * 时间复杂度：O(1)
 * 空间复杂度：O(n)
 * @author monklyh
 */
public class MyCircularQueueByArray {

    private int[] data;
    private int headIndex;

    /** 队列元素个数 */
    private int count;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueueByArray(int k) {
        data = new int[k];
        headIndex = -1;
        count = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        if (headIndex == -1){
            headIndex = 0;
        }
        // 计算当前队尾的索引
        data[(headIndex + count) % data.length] = value;
        count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()){
            headIndex = -1;
            return false;
        }
        count--;
        if (headIndex == data.length-1){
            headIndex = 0;
        }else{
            headIndex++;
        }
        return true;

    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return data[headIndex];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[(headIndex + count - 1) % data.length];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == data.length;
    }

    public static void main(String[] args) {
        test1();
    }


    public static void test1(){
        MyCircularQueueByArray circularQueue = new MyCircularQueueByArray(3);
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
