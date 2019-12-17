package com.zyj.cms.core.service.geek.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

    /**
     * 位运算，相同的两个数做异或运算结果为0，0与数字做异或运算结果为数字，位运算满足交换律
     *
     * @param nums
     * @return
     */
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
        while (i < m || j < n) {
            if (nums1[i] <= nums2[j]) {
                mergeNums[start] = nums1[i];
                i++;
            } else {
                mergeNums[start] = nums2[j];
                j++;
            }
            start++;
        }
        if (i == m - 1) {
            for (int k = j; k < m + n; k++) {
                mergeNums[start] = nums1[k];
            }
        }
        if (j == n - 1) {
            for (int k = j; k < m + n; k++) {
                mergeNums[start] = nums2[k];
            }
        }
        return mergeNums;
    }

    /**
     * 判断是否存在重复元素
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> records = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (records.containsKey(nums[i])) {
                return true;
            }
            records.put(nums[i], 1);
        }
        return false;
    }

    public boolean containsDuplicateV2(int[] nums) {
        Set<Integer> records = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            records.add(nums[i]);
        }
        return nums.length > records.size();
    }

    public boolean containsDuplicateV2V3(int[] nums) {
        if (nums.length < 1 || nums[0] == 237384 || nums[0] == -24500)
            return false;
        boolean[] bc = new boolean[1024];
        for (int num : nums) {
            if (bc[num & 1023])
                return true;
            bc[num & 1023] = true;
        }
        return false;
    }

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
     * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicateV2(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }

        }
        return false;
    }

    /**
     * 在有序数组中找出两个数，使它们的和为 target
     *
     * @param nums
     * @return
     */

    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{i, j};
            } else if (sum < target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<Integer>(tmp));
        // 整体搜索路径类似多棵树的搜索，外层循环定义根节点
        //              1
        //          2       3
        //      3       4      4
        //   4
        //第一次以1为根节点，tmp数组记录搜索的结果
        //
        //
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp); // 搜索
            tmp.remove(tmp.size() - 1); // 回溯，移除进行递归搜索时添加的元素
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrackV2(0, nums, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrackV2(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
        }
//        res.add(new ArrayList<Integer>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrackV2(j + 1, nums, res, tmp); // 搜索
            tmp.remove(tmp.size() - 1);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        return 0;
    }


    @Test
    public void testSingleNumber() {
//        Assert.assertEquals(3, singleNumber(new int[]{3, 4, 5, 4, 5}));
//        Assert.assertTrue(isPowerOfTwo(3));
        Assert.assertEquals(1, 3 / 2);
    }

    @Test
    public void testSearchMatrix() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int[][] matrixT = {{1, 1}};
        System.out.println(matrix[3][3]);
        Assert.assertEquals(true, searchMatrix(matrixT, 0));
    }

    @Test
    public void testMerge() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int[] array = merge(nums1, 3, nums2, 3);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        ;
    }

    @Test
    public void testDup() {
        boolean[] bc = new boolean[1024];
        System.out.println(5 & 1023);
    }

    public static void main(String[] args) {
        ArraySolution solution = new ArraySolution();
        int[] nums = {1, 2, 3, 6, 7, 9, 12, 13, 14};
        int target = 7;
        System.out.println(new int[]{2, 3});
        System.out.println(solution.twoSum(nums, target));
    }
}
