package com.lyh.personal.p1;

public class TestDuplicateNumbers {

    public static  void main(String[] args){
        int[] a = {5, 4, 2, 1, 4, 3};
        int[] b = {2, 3, 1, 0, 2, 5};
        test(a);
        test(b);
    }

    /**
     * ��Ŀ����һ������Ϊ n ����������������ֶ��� 0 �� n-1 �ķ�Χ�ڡ�
     * ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ģ�Ҳ��֪��ÿ�������ظ����Ρ�
     * ���ҳ�����������һ���ظ������֡�
     *
     * ����˼·��Ҫ��ʱ�临�Ӷ� O(N)���ռ临�Ӷ� O(1)����˲���ʹ������ķ�����Ҳ����ʹ�ö���ı�����顣
     * ������������Ԫ���� [0, n-1] ��Χ�ڵ����⣬���Խ�ֵΪ i ��Ԫ�ص������� i ��λ���Ͻ�����⡣
     * @param a
     */
    public static void test(int[] a){
        if (a == null){return;}
        int size = a.length;
        if (size <= 0){return;}

        int i = 0;
        while (true){
            //  ���ֵ���±겻��ȣ���ֵ������ȵ��±��ַ��
            // temp��ֵ�±��ַ�ľ�ֵ
            int v = a[i], temp = a[v];
            if (v != i){
                if (v == temp){
                    System.out.println("found num: " + a[i]);
                    return;
                }
                a[v] = v;
                // �Ƚ���ֵ��ʱ�����i��ַ�£��ȴ��´��ж�
                a[i] = temp;
            }else if (size == ++i){return;}

        }

    }



}
