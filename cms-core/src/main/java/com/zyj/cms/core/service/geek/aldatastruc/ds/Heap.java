package com.zyj.cms.core.service.geek.aldatastruc.ds;

/**
 * Author: zhouyajun
 * Date: 2019-08-02
 */
public class Heap {
    private int count;
    private int[] data;
    private int capacity;

    public Heap(int capacity) {
        this.data = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    public void swap(int[] nums, int x, int y) {
        int temp = nums[y];
        nums[y] = nums[x];
        nums[x] = temp;
    }

    public void insert(int value) {
        if (count >= capacity) {
            return;
        }
        count++;
        data[count] = value;
        int i = count;
        while (i / 2 > 0 && data[i] > data[i / 2]) {
            swap(data, i / 2, i);
            i = i / 2;
        }
    }

    public void insert(int[] nums) {

    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        data[1] = data[count];
        count--;
        heapify(data, count, 1);
    }

    private void heapify(int[] nums, int n, int i) {

        while (true) {
            int maxPos = i;
            if (2 * i <= count && nums[i] < nums[2 * i]) { // 和左子节点进行比较
                maxPos = 2 * i;
            }
            if (2 * i <= count && nums[i] < nums[2 * i] + 1) { // 和右子节点进行比较
                maxPos = 2 * i + 1;
            }
            if (maxPos == i) { // 没有子节点了
                break;
            }
            swap(nums, i, maxPos); // 交换数据
            i = maxPos; // 初始化到交换的位置
        }
    }

    /**
     * 建堆的过程，自上而下，如果从叶子节点开始就是自己和自己比较
     * 所以应该从第一个非叶子节点开始，对于完全二叉树，第一个非叶子节点的位置就是 n/2
     *
     * @param nums
     * @param n
     */
    public void buildHeap(int[] nums, int n) {
        for (int i = n / 2; i >= 1; i--) {
            heapify(nums, n, i);
        }
    }

    public void sort(int[] nums, int n) {
        buildHeap(nums, n);
        int k = n;
        while (k > 1) {
            swap(nums, 1, k); // 将根元素和最后一个元素进行交换
            k--;
            heapify(nums, k, 1); // 交换后对第一个元素进行堆化
        }
    }
}
