package com.lyh.personal.p1;

public class TestTree {

    public static void main(String[] args) {
        // ���򣬺�����֪����ǰ��.
        // ���������ADEFGHMZ
        // ���������AEFDHZMG
        String ldrStr = "ADEFGHMZ";
        String lrdStr = "AEFDHZMG";
        test(ldrStr, lrdStr);
        System.out.println("\r\n===");
    }

    public static void test(String ldrStr, String lrdStr){
        // ���򣬺�����֪����ǰ��.
        // ldr���������ADEFGHMZ
        // lrd���������AEFDHZMG

        // �ȰѸ������� G
        // �����ָø�����������
        int length = lrdStr.length();
        char rootV = lrdStr.charAt(length-1);
        System.out.print(rootV);
        if (length == 1){
            return;
        }

        StringBuilder ldrRightChild = new StringBuilder();
        StringBuilder ldrLeftChild = new StringBuilder();
        StringBuilder lrdRightChild = new StringBuilder();
        StringBuilder lrdLeftChild = new StringBuilder();
        boolean checkedRoot = false;
        for (int i = 0, j = 0, size = ldrStr.length(); i < size; i++){
            char ldrTempNode = ldrStr.charAt(i);
            if (!checkedRoot && rootV == ldrTempNode){
                checkedRoot = true;
                continue;
            }

            char lrdTempNode = lrdStr.charAt(j++);
            if (!checkedRoot){
                ldrLeftChild.append(ldrTempNode);
                lrdLeftChild.append(lrdTempNode);
            }else {
                ldrRightChild.append(ldrTempNode);
                lrdRightChild.append(lrdTempNode);
            }
        }
        if (ldrLeftChild.length() > 0 && lrdLeftChild.length() > 0){
            test(ldrLeftChild.toString(), lrdLeftChild.toString());
        }
        if (ldrRightChild.length() > 0 && lrdRightChild.length() > 0){
            test(ldrRightChild.toString(), lrdRightChild.toString());
        }

        /*String lrdLeftChildStr = null;
        String lrdRightChildStr = null;
        if (ldrLeftChild.length() > 0){
            lrdLeftChildStr = lrdStr.substring(0, ldrLeftChild.length());
            test(ldrLeftChild.toString(), lrdLeftChildStr);
        }

        if (ldrRightChild.length() > 0){
            if (lrdLeftChildStr != null){
                lrdRightChildStr = lrdStr.substring(lrdLeftChildStr.length(), lrdStr.length()-1);
            }else{
                lrdRightChildStr = lrdStr.substring(0, lrdStr.length()-1);
            }
            test(ldrRightChild.toString(), lrdRightChildStr);
        }*/

    }

    /**
     * �������ཻ�Ľ��
     */
    public Node test2(Node head1, Node head2){
        if (head1 == head2){
            return head1;
        }
        Node temp2 = head2;
        while (head1 != null){
            while (head2 != null){
                if (head1 == head2){
                    return head2;
                }
                if (head1 == head2.next){
                    return head1;
                }
                head2 = head2.next;
            }
            head1 = head1.next;
            head2 = temp2;
        }
        return null;
    }

    class Node {
        Node next;
        public Node(){
        }
        public boolean hasNext(){
            return next != null;
        }
    }

}
