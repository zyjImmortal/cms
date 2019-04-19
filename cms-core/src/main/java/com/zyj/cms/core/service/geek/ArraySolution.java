package com.zyj.cms.core.service.geek;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouyajun
 * @date 2019/4/16
 */
public class ArraySolution {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗
     *
     * @param nums
     * @return
     */

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            map.put(nums[i], (value == null ? 0 : value) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    private int contain(int[] nums, int element) {
        for (int i = 0; i < nums.length; i++) {
            if (element == nums[i]) {
                return 1;
            }
        }
        return -1;
    }

    public int singleNumberV2(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }
        return res;
    }

    /**
     * 求众数，出现次数最多的元素
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int length = nums.length;
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();
        for (Integer i : nums) {
            Integer times = result.get(i);
            result.put(i, (times == null ? 0 : times) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (entry.getValue() > length / 2) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 二维矩阵中搜索给定元素
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int width = matrix[0].length;
        int length = matrix.length;
        int i = width - 1;
        int j = 0;
        while (i >= 0 && j < length) {
            if (matrix[j][i] == target) {
                return true;
            } else if (matrix[j][i] > target) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergeNums = new int[m + n];
        int i = 0, j = 0;
        int start = 0;
        while (i < m  || j < n) {
            if (nums1[i] <= nums2[j]) {
                mergeNums[start] = nums1[i];
                i++;
            } else {
                mergeNums[start] = nums2[j];
                j++;
            }
            start++;
        }
        if (i == m -1){
            for (int k = j; k < m+n; k++) {
                mergeNums[start] = nums1[k];
            }
        }
        if (j == n - 1){
            for (int k = j; k < m+n; k++) {
                mergeNums[start] = nums2[k];
            }
        }
        return mergeNums;
    }

    @Test
    public void testSingleNumber() {
        Assert.assertEquals(3, singleNumber(new int[]{3, 4, 5, 4, 5}));
    }

    @Test
    public void testSearchMatrix() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrixT = {{1, 1}};
        System.out.println(matrix[3][3]);
        Assert.assertEquals(true, searchMatrix(matrixT, 0));
    }

    @Test
    public void testMerge(){
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] array = merge(nums1, 3, nums2, 3);
        for (int i = 0; i <array.length ; i++) {
            System.out.println(array[i]);
        };
    }
}
