package com.lyh.personal.demo.algorithm.leeteCode.learning.queue;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 */
public class BFS4OpenLock {

    /**
     * 我们可以将 0000 到 9999 这 10000 状态看成图上的 10000 个节点，两个节点之间存在一条边，
     * 当且仅当这两个节点对应的状态只有 1 位不同，
     * 且不同的那位相差 1（包括 0 和 9 也相差 1 的情况），
     * 并且这两个节点均不在数组 deadends 中。
     * 那么最终的答案即为 0000 到 target 的最短路径。
     *
     * 我们用广度优先搜索来找到最短路径，从 0000 开始搜索。
     * 对于每一个状态，它可以扩展到最多 8 个状态，
     * 即将它的第 i = 0, 1, 2, 3 位增加 1 或减少 1，
     * 将这些状态中没有搜索过并且不在 deadends 中的状态全部加入到队列中，
     * 并继续进行搜索。注意 0000 本身有可能也在 deadends 中。
     *
     * 时间复杂度：O(N^2 * A^N + D)。我们用 A 表示数字的个数，N 表示状态的位数，
     * D 表示数组 deadends 的大小。在最坏情况下，我们需要搜索完所有状态，状态的总数为 O(A^N)。
     * 对于每个状态，我们要枚举修改的位置，需要 O(N) 的时间，枚举后得到新的状态同样需要 O(N) 的时间。
     *
     * 空间复杂度：O(A^N + D)用来存储队列以及 deadends 的集合。
     *
     */
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        if (dead.contains("0000")){return -1;}

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);

        Set<String> seen = new HashSet<>();
        seen.add("0000");

        int deepth = 0;
        while(!queue.isEmpty()){
            String str = queue.poll();
            if (str == null){
                // 用null区分拨动一次后的结果
                deepth++;
                if (queue.peek() != null){
                    queue.offer(null);
                }
            }else if (str.equals(target)){
                return deepth;
            }else if (!dead.contains(str)){
                // 表示4个拨盘，其中一个拨动一次的可能结果
                for (int i = 0; i < 4; i++){
                    // 表示拨动转盘，当前数 +1、-1
                    for (int d = -1; d <= 1; d+=2){
                        // 拨动后的数字
                        int y = (str.charAt(i) - '0' + d + 10) % 10;
                        String tempstr = str.substring(0, i) + y + str.substring(i+1);
                        if (!seen.contains(tempstr)){
                            seen.add(tempstr);
                            // 将拨动一次的可能结果入队列
                            queue.offer(tempstr);
                        }

                    }
                }
            }
        }
        return -1;
    }



}
