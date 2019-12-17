package com.zyj.cms.core.service.geek.AlAndDataStruc.ds;

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

    public void insert(int[] nums){

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

    public static void buildHeap(){

    }
}
