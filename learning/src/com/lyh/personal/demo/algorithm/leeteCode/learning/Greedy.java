package com.lyh.personal.demo.algorithm.leeteCode.learning;

/**
* 贪心算法题解
 * 贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择，就能得到问题的答案。
 * 贪心算法需要充分挖掘题目中条件，没有固定的模式，解决有贪心算法需要一定的直觉和经验。
 *
 * 贪心算法不是对所有问题都能得到整体最优解。能使用贪心算法解决的问题具有「贪心选择性质」。
 * 「贪心选择性质」严格意义上需要数学证明。能使用贪心算法解决的问题必须具备「无后效性」，即某个状态以前的过程不会影响以后的状态，只与当前状态有关。
*/
public class Greedy {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * 说明：你不能倾斜容器。
     * 示例 1：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int maxV = 0;
        for (int i = 0, j = height.length-1; i < j;){
            maxV = height[i] < height[j] ?
                    Math.max(maxV, (j-i) * height[i++]) :
                    Math.max(maxV, (j-i) * height[j--]);
        }
        return maxV;

    }

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     *
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     *
     * 0 <= j <= nums[i] 
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     * 
     *示例 1:
     *
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。

     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int steps = 0;
        // 当前最大步长起跳的下标
        int maxPostion = 0;
        // 当前步跳的最远边界下标
        int stepIndex = 0;
        // 不需要访问最后一个元素
        for (int i = 0; i < nums.length-1; ++i){
            maxPostion = Math.max(maxPostion, i + nums[i]);
            if (i == stepIndex){
                // 每过一次边界，记一次步跳
                stepIndex = maxPostion;
                steps++;
            }
        }
        return steps;
    }





}
