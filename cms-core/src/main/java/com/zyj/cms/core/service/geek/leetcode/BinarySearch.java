package com.zyj.cms.core.service.geek.leetcode;

public class BinarySearch {

    public static int binarySearch(int[] nums, int target) {
        return binarySearchV3(nums, 0, nums.length - 1, target);
    }

    /**
     * 二分查找算法，对数据结构有特定的要求，整数有序的数组,,一下是常规写法
     *
     * @param nums
     * @param l
     * @param r
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
//            int mid = l + (r - l) / 2;
//            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变形写法
     * V2、查找第一个值等于给定值的元素
     * V3、查找最后一个值等于给定值的元素
     * 3、查找第一个大于等于给定值的元素
     * 4、查找第一个小于等于给定值的元素
     *
     * @param
     */
    public static int binarySearchV2(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                if (mid == 0 || nums[mid - 1] != target) {
                    return mid;
                } else {
                    r = mid - 1;
                }

            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchV3(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                if (mid == r || nums[mid + 1] != target) {
                    return mid;
                } else {
                    l = mid + 1;
                }

            } else if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 5, 5, 5, 5, 5, 5, 6, 7, 8, 9};
        System.out.println(BinarySearch.binarySearch(nums, 5));
//        System.out.println(9 / 2);
    }
}
