package com.lyh.personal.demo.algorithm.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * 检测无环单链表相交的结点
 * 参考：https://blog.csdn.net/sinat_36722750/article/details/82228416
 * @author laiyh
 * @version 1.0
 * @date 2020/8/21 17:28
 */
public class ListMeet {

    public static List<ListCircle.Node> creatList(int len1, int len2, int meetNum){
        ListCircle.Node head1 = new ListCircle.Node(1);
        ListCircle.Node index = head1;
        ListCircle.Node meetNode = null;

        for (int i = 2; i <= len1; i++){
            ListCircle.Node next = new ListCircle.Node(i);
            index.setNext(next);
            index = next;
            if (i == meetNum){
                meetNode = index;
                meetNode.setV(i*10+i);
            }
        }

        ListCircle.Node head2 = new ListCircle.Node(1);
        index = head2;
        for (int i = 2; i < len2 - len1 + meetNum; i++){
            ListCircle.Node next = new ListCircle.Node(i);
            index.setNext(next);
            index = next;
        }
        index.setNext(meetNode);
        List<ListCircle.Node> heads = new ArrayList<>();
        heads.add(head1);
        heads.add(head2);
        return heads;
    }

    /**
     * 无环时的遍历两个链表
     * 时间复杂度O(n^2)
     * @param h1
     * @param h2
     */
    public static void check0(ListCircle.Node h1, ListCircle.Node h2){
        if (h1 == null || h2 == null){
            return;
        }
        if (h1 == h2){
            System.out.println("链表相交结点 头结点：" + h1 + " " + h1.getV());
        }
        ListCircle.Node tmp1 = h1;
        while (tmp1 != null){
            ListCircle.Node tmp2 = h2;
            while (tmp2 != null){
                if (tmp2 == tmp1){
                    System.out.println("链表相交结点：" + tmp1 + " " + tmp1.getV());
                    return;
                }
                tmp2 = tmp2.getNext();
            }
            tmp1 = tmp1.getNext();
        }
    }


    /**
     * 创建两个栈，第一个栈存储第一个链表的节点，
     * 第二个栈存储第二个链表的节点，
     * 直至链表的所有节点入栈，
     * 通过取两个栈的栈顶元素节点判断是否相等即可判断两个链表是否相交。
     * 从第一个相交节点之后，后续节点均相交直至链表结束。
     * 出栈直至两个节点不相同时，则这个节点的后一个节点是第一个相交节点
     *
     * 空间复杂度O(len1+len2)
     * @param h1
     * @param h2
     */
    public static void checkWithStack(ListCircle.Node h1, ListCircle.Node h2){
        ListCircle.Node index1 = h1;
        ListCircle.Node index2 = h2;
        Stack<ListCircle.Node> s1 = new Stack<>();
        Stack<ListCircle.Node> s2 = new Stack<>();
        while (index1 != null || index2 != null){
            if (index1 != null ){
                s1.add(index1);
                index1 = index1.getNext();
            }
            if (index2 != null){
                s2.add(index2);
                index2 = index2.getNext();
            }
        }

        if (s1.peek() == s2.peek()){
            ListCircle.Node meetNode;
            do {
                meetNode = index1;
                index1 = s1.pop();
                index2 = s2.pop();
            }while (index1 == index2);
            System.out.println("两链表相交，相交的结点为：" + meetNode
                    + (meetNode == null ? "" : " : " + meetNode.getV()));
        }else {
            System.out.println("两链表不相交");
        }

    }

    /**
     * 同时遍历两个链表到尾部，同时记录两个链表的长度。
     * 若两个链表最后的一个节点相同，则两个链表相交。
     * 有两个链表的长度后，我们就可以知道哪个链表长，
     * 设较长的链表长度为len1,短的链表长度为len2。
     * 则先让较长的链表向后移动(len1-len2)个长度。
     * 然后开始从当前位置同时遍历两个链表，
     * 当遍历到的链表的节点相同时，
     * 则这个节点就是第一个相交的节点。
     *
     * （其实是缩短了链表比较的长度）时间复杂度为O(len1+len2)
     * @param h1
     * @param h2
     */
    public static void checkWithLength(ListCircle.Node h1, ListCircle.Node h2){
        ListCircle.Node index1 = h1;
        ListCircle.Node index2 = h2;
        int len1 = 0;
        int len2 = 0;
        while (index1.hasNext() || index2.hasNext()){
            if (index1.hasNext()){
                len1++;
                index1 = index1.getNext();
            }
            if (index2.hasNext()){
                len2++;
                index2 = index2.getNext();
            }
        }
        if (index1 != index2){
            System.out.println("两链表不相交");
            return;
        }
        index1 = h1;
        index2 = h2;
        int offset = len1 - len2;
        boolean moveList1 = offset > 0;
        if (offset != 0){
            offset = Math.abs(offset);
            // 先让较长的链表向后移动
            for (int i = 0; i < offset; i++){
                if (moveList1){
                    index1 = index1.getNext();
                }else{
                    index2 = index2.getNext();
                }
            }
        }

        while (index1 != null && index2 != null){
            if (index1 == index2){
                System.out.println("两链表相交，相交的结点为：" + index1
                        + " : " + index1.getV());
                break;
            }
            index1 = index1.getNext();
            index2 = index2.getNext();
        }

    }

    /**
     *  既然连个链表一旦相交，相交节点一定有相同的内存地址，
     *  而不同的节点内存地址一定是不同的，
     *  那么不妨利用内存地址建立哈希表，
     *  如此通过判断两个链表中是否存在内存地址相同的节点判断两个链表是否相交。
     *  具体做法是：遍历第一个链表，并利用地址建立哈希表，
     *  遍历第二个链表，
     *  看看地址哈希值是否和第一个表中的节点地址值有相同即可判断两个链表是否相交。
     *
     *  时间复杂度O(length1 + length2)
     * @param h1
     * @param h2
     */
    public static void checkWithHash(ListCircle.Node h1, ListCircle.Node h2){
        ListCircle.Node index1 = h1;
        ListCircle.Node index2 = h2;
        HashSet<ListCircle.Node> nodes = new HashSet<>();
        while (index1 != null || index2 != null){
            if (nodes.contains(index1)){
                System.out.println("两链表相交，相交的结点为：" + index1
                        + " : " + index1.getV());
                return;
            }else if (nodes.contains(index2)){
                System.out.println("两链表相交，相交的结点为@：" + index2
                        + " : " + index2.getV());
                return;
            }
            if (index1 != null){
                nodes.add(index1);
                index1 = index1.getNext();
            }
            if (index2 != null){
                nodes.add(index2);
                index2 = index2.getNext();
            }
        }


    }


    public static void main(String[] args) {
        int meetNum = 4;
        List<ListCircle.Node> heads = creatList(6, 11, meetNum);
        ListCircle.Node index1 = heads.get(0);
        ListCircle.Node index2 = heads.get(1);
        printfList(index1);
        printfList(index2);
        System.out.println("<<<直接遍历法：");
        check0(heads.get(0), heads.get(1));
        System.out.println(">>>直接遍历法");

        System.out.println("<<<使用栈法：");
        checkWithStack(index1, index2);
        System.out.println(">>>使用栈法");

        System.out.println("<<<记录长度位移法：");
        checkWithLength(index1, index2);
        System.out.println(">>>记录长度位移法");

        System.out.println("<<<哈希地址法：");
        checkWithHash(index1, index2);
        System.out.println(">>>哈希地址法");
    }

    public static void printfList(ListCircle.Node head){
        ListCircle.Node index = head;
        System.out.println("构建的链表：");
        while (index != null){
            System.out.print(index.getV());

            if (index.hasNext()){
                System.out.print( " -> ");
            }
            index = index.getNext();
        }
        System.out.println("");

    }
}
