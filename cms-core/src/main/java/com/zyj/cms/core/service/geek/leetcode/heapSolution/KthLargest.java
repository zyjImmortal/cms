package com.zyj.cms.core.service.geek.leetcode.heapSolution;

import java.util.PriorityQueue;

/**
 * @author : zhouyajun
 * @date : 2020-02-03
 */
public class KthLargest {
    private final PriorityQueue<Integer> priorityQueue;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.priorityQueue = new PriorityQueue<>(k);
        for (int i : nums) {
            this.add(i);
        }
    }

    public int add(int val) {
        if (this.priorityQueue.size() < this.k) {
            this.priorityQueue.offer(val);
        } else if (this.priorityQueue.peek() < val) {
            // 删除堆顶元素
            this.priorityQueue.poll();
            this.priorityQueue.offer(val);
        }
        return this.priorityQueue.peek();
    }
}
