package com.lyh.personal.demo.algorithm.leeteCode.learning;

import java.util.Arrays;

/**
 * 求数组中的第k大元素
 */
public class GetTheKthElementFromAarrry {

    public static void main(String[] args) {
        // 第k大元素
//        int[] as = new int[]{2,4,5,9,5,8};
        int[] as = new int[]{10, 1, 35, 61, 89, 36, 55};
        // 快排
        Arrays.sort(as);
        int k = 4;
        int size = as.length;
        long time = System.currentTimeMillis();
        System.out.println(as[size - k] + "  wateTime:" + (System.currentTimeMillis() - time));
        System.out.println(Arrays.toString(as));

        GetTheKthElementFromAarrry a = new GetTheKthElementFromAarrry();
        int[] as2 = new int[]{10, 1, 35, 61, 89, 36, 55};
        time = System.currentTimeMillis();
        System.out.println(a.findKthLargest(as2, 5) + "  wateTime:" + (System.currentTimeMillis() - time));

        System.out.println(GetTheKthElementFromAarrry.findNumberK(as2, 5));
    }


    /**
     * 最小顶堆
     */
    public  int findKthLargest(int[] nums, int k) {

        MaxHeap maxHeap = new MaxHeap(nums.length);
        for (int num : nums) {
            maxHeap.insert(num);
        }
        int ret = 0;
        for (int i = 0; i < k; i++) {
            ret = maxHeap.extract();
        }
        return ret;
    }

    class MaxHeap{
        int[] data;
        int count;
        int capacity;

        MaxHeap(int capacity){
            this.capacity = capacity;
            count = 0;
            data = new int[capacity+1];
        }

        boolean isEmpty(){
            return count==0;
        }

        void insert(int e){
            data[++count] = e;
            shiftUp(count);
        }
        int extract(){
            int ret = data[1];
            swap(1, count--);
            shiftDown(1);
            return ret;
        }

        private void shiftUp(int k){
            int i;
            while ((i = k/2) > 0){
                if (data[k] > data[i]){
                    swap(k,i);
                    k = i;
                }else {
                    break;
                }
            }
        }

        private void shiftDown(int k){
            while (k*2 <= count){
                int j = k*2;
                // 如果右子树大于左子树，则定位到右子树
                if (j+1 <= count && data[j+1] > data[j]){
                    j++;
                }
                // 顶（即根）值大于子树值，则下沉
                if (data[j] > data[k]){
                    swap(k,j);
                    k = j;
                }else {
                    // 比左右子树的值都小，则不操作
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }


    /**
     * 寻找第k大元素
     * @param array 待调整的数组
     * @param k 第几大
     * @return
     */
    public static int findNumberK(int[] array, int k) {
        //1.用前k个元素构建小顶堆
        buildHeap(array, k);
        //2.继续遍历数组，和堆顶比较
        for (int i = k; i < array.length; i++) {
            if(array[i] > array[0]) {
                array[0] = array[i];
                downAdjust(array, 0, k);
            }
        }
        //3.返回堆顶元素
        return array[0];
    }

    private static void buildHeap(int[] array, int length) {
        //从最后一个非叶子节点开始，依次下沉调整
        for (int i = (length - 2) / 2; i >= 0; i--) {
            downAdjust(array, i, length);
        }
    }

    /**
     * 下沉调整
     * @param array 待调整的堆
     * @param index 要下沉的节点
     * @param length 堆的有效大小
     */
    private static void downAdjust(int[] array, int index, int length) {
        //temp保存父节点的值，用于最后的赋值
        int temp = array[index];
        int childIndex = 2 * index + 1;
        while (childIndex < length) {
            //如果有右孩子，且右孩子小于左孩子的值，则定位到右孩子
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex]) {
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，直接跳出
            if (temp <= array[childIndex]){
                break;
            }
            //无需真正交换，单项赋值即可
            array[index] = array[childIndex];
            index = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[index] = temp;
    }

}
