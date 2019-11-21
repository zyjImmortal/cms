package com.zyj.cms.core.service.geek;


/**
 * 归并排序：
 * 思想：先把数组从中间分成前后两部分，然后对前后两部分分别排序，再将排序好的两部分合并到一起
 * 分治思想-递归实现，两个有序数组的合并后仍然有序
 */
public class MergeQuickSort {

    public static void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public static void mergeSort(int[] nums, int p, int r) {
        if (p >= r) {
            return;
        }
        int mid = p + (p + r) / 2;
        mergeSort(nums, p, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, p, mid, r);
    }

    private static void merge(int[] nums, int p, int mid, int r) {
        int[] temp = new int[r - p + 1];
        int i = p, j = mid, z = 0;
        while (i <= mid && j <= r) {
            if (nums[i] > nums[j]) {
                nums[z] = nums[i];
                i++;
                z++;
            } else {
                temp[z] = nums[j];
                j++;
                z++;
            }
        }
        if (i < mid) {
            for (int m = i; m <= mid; m++) {
                temp[z] = nums[m];
                z++;
            }
        }
        if (j < r) {
            for (int n = j; n <= r; n++) {
                temp[z] = nums[n];
                z++;
            }
        }
        for (; p <= r; p++) {
            nums[p] = temp[p];
        }
    }

    public static void mergerV2(int[] nums, int p, int mid, int r) {
        int[] copy = nums.clone();
        // 定义一个指针表示从什么位置开始修改原来的数组,i 指针表示左半边的起始位置，j 表示右半边的起始位置
        int k = p, i = p, j = mid + 1;
        while (k <= r) {
            if (i > mid) {
                nums[k++] = copy[j++];
            } else if (j >= r) {
                nums[k++] = copy[i++];
            } else if (nums[j] < copy[i]) {
                nums[k++] = nums[j++];
            } else {
                nums[k++] = nums[i++];
            }
        }
    }
}
