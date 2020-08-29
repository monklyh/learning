package com.lyh.personal.demo.algorithm.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 检测有或无环单链表相交的结点
 * 相交的：要么都是无环，要么都是有环
 * 参考：https://blog.csdn.net/sinat_36722750/article/details/82228416
 * @author laiyh
 * @version 1.0
 * @date 2020/8/24 16:02
 */
public class ListMeet2 extends ListMeet {

    static class CircleList{
        ListCircle.Node head;
        ListCircle.Node circleNode;
        ListCircle.Node meetNode;
        int len;

        public CircleList(int len, ListCircle.Node head){
            this.len = len;
            this.head = head;
        }

        public ListCircle.Node getHead() {
            return head;
        }

        public void setHead(ListCircle.Node head) {
            this.head = head;
        }

        public ListCircle.Node getCircleNode() {
            return circleNode;
        }

        public void setCircleNode(ListCircle.Node circleNode) {
            this.circleNode = circleNode;
        }

        public ListCircle.Node getMeetNode() {
            return meetNode;
        }

        public void setMeetNode(ListCircle.Node meetNode) {
            this.meetNode = meetNode;
        }

        public int getLen() {
            return len;
        }

        public void setLen(int len) {
            this.len = len;
        }
    }

    public static List<CircleList> creatCircleList(int circleNum,
                                       int len1, int len2,
                                           int meetNum){
        if (len1 > len2){
            int temp = len1;
            len1 = len2;
            len2 = temp;
        }
        ListCircle.Node meetNode = null;

        ListCircle.Node head1 = new ListCircle.Node(1);
        ListCircle.Node index = head1;
        ListCircle.Node circleNode1 = null;
        CircleList circleList1 = new CircleList(len1, head1);
        for (int i = 2; i <= len1; i++){
            ListCircle.Node next = new ListCircle.Node(i);
            index.setNext(next);
            index = next;
            if (i == meetNum){
                meetNode = index;
                meetNode.setV(i*10+i);
                circleList1.setMeetNode(meetNode);
            }
            if (i == circleNum){
                circleNode1 = index;
                circleList1.setCircleNode(circleNode1);
            }
        }
        if (circleNode1 != null){
            index.setNext(circleNode1);
        }

        ListCircle.Node head2 = new ListCircle.Node(1);
        index = head2;
        CircleList circleList2 = new CircleList(len2, head2);
        circleList2.setMeetNode(meetNode);
        int offset = meetNum;
        // 相交点在环内
        if (circleNum >= meetNum){
            // 此时两链表的环入口相同
            circleList2.setCircleNode(circleNode1);
        }else{
            offset = circleNum;
            circleList2.setCircleNode(meetNode);
        }
        for (int i = 2; i < len2 - len1 + offset; i++){
            ListCircle.Node next = new ListCircle.Node(i);
            index.setNext(next);
            index = next;
        }
        index.setNext(meetNode);

        List<CircleList> heads = new ArrayList<>();
        heads.add(circleList1);
        heads.add(circleList2);
        return heads;
    }

    /**
     * 时间复杂度：O(len1+2*len2)
     * 空间复杂度：O(len1)
     * @param h1
     * @param h2
     */
    public static void checkWithHash(ListCircle.Node h1, ListCircle.Node h2){
        ListCircle.Node index1 = h1;
        ListCircle.Node index2 = h2;
        HashSet<ListCircle.Node> nodes = new HashSet<>();

        // 先遍历1个链表，将其各个节点地址存入哈希表
        while (index1 != null){
            if (nodes.contains(index1)){
//                System.out.println("1链表的环入口节点为：" + index1 + " : " + index1.getV());
                break;
            }
            nodes.add(index1);
            index1 = index1.getNext();
        }
        ListCircle.Node circleNode1 = index1;
        boolean firstAriveCircleNdoe = false;
        ListCircle.Node circleNode2 = circleNode1 == null ? null : ListCircle.toFindTheNodeIntoCircle(index2);

        boolean meet = false;
        while (index2 != null){
            if (meet = nodes.contains(index2)){
                if (circleNode1 == null){
                    System.out.println("两无环链表相交节点为：" + index2 + " : " + index2.getV());
                }else{
                    System.out.println("两有环链表相交的结点为：" + index2 + " : " + index2.getV()
                            + "\r\n 1-环入口为：" + circleNode1 +  " : " + circleNode1.getV()
                            + "\r\n 2-环入口为：" + circleNode2 +  " : " + circleNode2.getV());
                }

                break;
            }
            index2 = index2.getNext();
            if (index2 == circleNode2){
                // 有环不相交的情况，可以跳出循环
                if (!firstAriveCircleNdoe) {
                    firstAriveCircleNdoe = true;
                }else{
                    break;
                }
            }
        }

        if (!meet){
            System.out.println("两链表不相交");
        }

    }


    public static void main(String[] args) {
        int len1 = 7;
        int len2 = 9;
        int circleNum = 6;
        int meetNum = 5;

        // 有环相交
        System.out.println("##### 有环相交 #####");
        List<CircleList> heads = creatCircleList(circleNum, len1, len2, meetNum);
        CircleList ch1 = heads.get(0);
        CircleList ch2 = heads.get(1);
        printfList2(ch1);
        printfList2(ch2);
        checkWithHash(ch1.getHead(), ch2.getHead());
        System.out.println("##### 有环相交 end #####");

        /*// 有环不相交
        System.out.println("##### 有环不相交 #####");
        ListCircle.Node h1 = ListCircle.createCircleList(circleNum, len1);
        ListCircle.Node h2 = ListCircle.createCircleList(circleNum, len2);
        ListCircle.printfCircleList(h1, circleNum);
        ListCircle.printfCircleList(h2, circleNum);
        checkWithHash(h1, h2);
        System.out.println("##### 有环不相交 end #####");

        // 无环不相交
        System.out.println("##### 无环不相交 #####");
        List<ListCircle.Node> hs = ListMeet.creatList(len1, len2, 0);
        ListMeet.printfList(hs.get(0));
        ListMeet.printfList(hs.get(1));
        checkWithHash(hs.get(0), hs.get(1));
        System.out.println("##### 无环不相交 end #####");

        // 无环相交
        System.out.println("##### 无环相交 #####");
        hs = ListMeet.creatList(len1, len2, meetNum);
        ListMeet.printfList(hs.get(0));
        ListMeet.printfList(hs.get(1));
        checkWithHash(hs.get(0), hs.get(1));
        System.out.println("##### 无环相交 end #####");*/


    }


    public static void printfList2(CircleList cl1){
        ListCircle.Node index = cl1.getHead();
        System.out.println("构建的链表：");
        ListCircle.Node circleNodeTmp = null;
        while (index != null){
            System.out.print(index.getV());
            if (circleNodeTmp != null && index == circleNodeTmp){
                // 第二次遇到环入口（即上个节点是最后一个节点）
                System.out.println(": " + circleNodeTmp + " === " + index + " : " + index.getV());
                System.out.println("meetNode- " + cl1.getMeetNode() + " : " + cl1.getMeetNode().getV());
                break;
            }

            System.out.print( " -> ");
            if (cl1.getCircleNode() == index){
                circleNodeTmp = index;
            }
            index = index.getNext();
        }
        System.out.println("");

    }
}
