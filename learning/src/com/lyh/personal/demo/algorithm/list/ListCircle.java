package com.lyh.personal.demo.algorithm.list;

/**
 * 检测单链表的环
 * 判断链表相交
 * 参考：https://blog.csdn.net/tyler_download/article/details/53691695
 *      https://blog.csdn.net/sinat_36722750/article/details/82228416
 * @author laiyh
 * @version 1.0
 * @date 2020/8/20 17:47
 */
public class ListCircle {

    public static class  Node{
        private int v;
        private Node next = null;

        public Node(int v){
            this.v = v;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public boolean hasNext(){
            return next != null;
        }
    }

    public static Node createCircleList(int circleNum, int listLength){
        Node head = null;
        Node circleNode = null;
        int i = 1;
        Node temp = null;
        do {
            if (head == null){
                head = new Node(i);
                temp = head;
            }
            if (listLength == 1){
                return head;
            }
            Node next = new Node(++i);
            if (next.getV() == circleNum){
                circleNode = next;
            }else if (head.getV() == circleNum){
                circleNode = head;
            }
            temp.setNext(next);
            temp = next;
        }while(i < listLength);
        temp.setNext(circleNode);
        return head;
    }

    /**
     * 寻找环入口的结点
     * 参考：https://techlog.cn/article/list/10183398
     * 快慢指针法：使用两个指针分别从队列的起点出发，
     * 一个指针前进一次遍历1个节点，另一个指针前进一次，
     * 遍历2个节点，如果队列中有环，那么我们可以确信，
     * 前进若干次之后，两个指针会相遇；
     *
     * 公式1：m*n*time-n*time=k*circleLen
     * m为快指针比慢指针的移动倍数；n为慢指针步长；
     * （一般n=1,m=2；避免出现快指针直接越过慢指针的情况）
     * k为整数，表示两个指针重合时，快比慢相差几个环；
     * time表示指针移动的次数，两个指针的次数是相同的；
     *
     * 公式2：l+d=kc => l=kc-d => l=(k-1)c+(c-d)
     * l为头结点（不包含）到环入口（包含）经过的结点数；
     * d为相遇结点到入口（不包含）的经过结点数（有可能绕圈了）；
     * k为整数（k>=1）； c表示环的结点数，包含入口；
     * 从上最后的式子可以得出，
     * 从起始点出发到成环点的距离与相遇点出发到成环点的距离之间只差 (k-1) 个；
     * 也就是说，两个指针如果以相同步长分别从起始点与相遇点出发，相遇时一定在成环点
     *
     */
    public static Node toFindTheNodeIntoCircle(Node head){
        System.out.println("寻找环入口：");
        if (head.getNext() == head){
            System.out.println("成环点：" + head + " " + head.getV() + " 链表只有一个结点");
        }else if (head.getNext() == null){
            System.out.println("无环，链表只有一个结点");
        }
        Node quickPoint = head;
        Node slowPoint = head;
        int m = 2;
        int time = 0;
        while(true){
            time++;
            // 快指针比慢指针快两倍
            for (int i = 0; i < m; i++){
                if (quickPoint.hasNext()){
                    quickPoint = quickPoint.getNext();
                }
            }
            // 无环的情况
            if (quickPoint == null){
                System.out.println("链表无环");
                break;
            }

            slowPoint = slowPoint.getNext();

            if (slowPoint == quickPoint){
                System.out.println("指针相遇<< time=" + time
                        + " 相遇点：" + slowPoint.getV());
                slowPoint = head;
                int lenWithoutCircle = 1;
                int circleLen = 0;
                Node meetNode = quickPoint;
                Node intoNode = null;
                int k = 0;
                while (true){
                    slowPoint = slowPoint.getNext();
                    quickPoint = quickPoint.getNext();
                    if (quickPoint == meetNode){
                        // 统计两次相遇时，快指针在环上走了几圈
                        k++;
                    }
                    circleLen++;

                    if (meetNode != head){
                        // 头结点成环时，不计算lenWithoutCircle
                        if (slowPoint != quickPoint){
                            lenWithoutCircle++;
                        }else if (intoNode == null){
                            intoNode = slowPoint;
                            System.out.println("成环点：" + intoNode + " " + intoNode.getV());
                            // 最后一个结点为成环点
                            if (intoNode == intoNode.getNext()){
                                circleLen = 1;
                                System.out.println("链表长=" + (circleLen + lenWithoutCircle)
                                        + " 环长 circleLen=" + circleLen
                                        + " lenWithoutCircle=" + lenWithoutCircle);
                                return intoNode;
                            }
                        }
                    }

                    if (slowPoint == meetNode && slowPoint != slowPoint.getNext()){
                        if (slowPoint == head){
                            lenWithoutCircle = 0;
                            System.out.println("成环点：" + head + " " + head.getV());
                            intoNode = head;
                        }
                        circleLen /= k;
                        // 计算环长用
                        System.out.println("链表长=" + (circleLen + lenWithoutCircle)
                                + " 环长 circleLen=" + circleLen
                                + " lenWithoutCircle=" + lenWithoutCircle);
                        return intoNode;
                    }
                }

            }
        }
        return null;
    }


    public static void main(String[] args) {
        int circleNum = 6;
        int len = 9;
        Node head = createCircleList(circleNum, len);
        /*Node index = head;
        Node circleNode = null;
        int circleLen = 0;
        // check the creator if successfull
        System.out.println("构建的有环链表：");
        while (index != null){
            System.out.print(index.getV());
            if (circleLen > 0){circleLen++;}
            if (circleNode != null && index.getV() == circleNode.getV()){
                System.out.println(": " + circleNode + " === " + index + " circleLen=" + (circleLen-1));
                break;
            }
            System.out.print( " -> ");
            if (index.getV() == circleNum){
                circleLen = 1;
                // mark the cicle node
                circleNode = index;
            }
            index = index.getNext();
        }*/
        printfCircleList(head, circleNum);
        System.out.println(toFindTheNodeIntoCircle(head));
    }

    public static void printfCircleList(Node head,  int circleNum){
        Node index = head;
        Node circleNode = null;
        int circleLen = 0;
        System.out.println("构建的有环链表：");
        while (index != null){
            System.out.print(index.getV());
            if (circleLen > 0){circleLen++;}
            if (circleNode != null && index.getV() == circleNode.getV()){
                System.out.println(": " + circleNode + " === " + index + " circleLen=" + (circleLen-1));
                break;
            }
            System.out.print( " -> ");
            if (index.getV() == circleNum){
                circleLen = 1;
                // mark the cicle node
                circleNode = index;
            }
            index = index.getNext();
        }
    }
}
