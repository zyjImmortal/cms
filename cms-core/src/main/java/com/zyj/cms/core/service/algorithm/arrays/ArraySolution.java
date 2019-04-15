package com.zyj.cms.core.service.algorithm.arrays;

/**
 * @author zhouyajun
 * @date 2019/4/9
 */
public class ArraySolution {

    /**
     * 从排序数组删除重复元素
     *
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
     * <p>
     * 思路：
     * 题目设置不能使用额外内存空间，必须原地修改，那只能对数组进行赋值操作或者利用临时变量交换位置
     * 所以可以将不相同的元素移动到数组的最前面，再返回不相同元素个数，可以看做是移除了重复元素的数组长度，
     * 根据长度就可以取出最前面的元素
     * 问题：
     *     相同的元素如何只移动一次，怎样判断元素已经被移动了
     * 方案:
     *     数组前面的元素已经是不重复的，那么我们取最后一个元素和将要移动的元素进行比对，如果相等则判定时已经移动过的。
     *     这里还是利用数组的有序
     *
     * @param nums 传入数组引用
     * @return 返回去重后数组长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 因为数组是有序的，所以取第一个做为基准元素，遍历其他元素和基准元素进行比较
        // 如果和基准元素相等则进行下一轮循环，如果不相等且和上一个元素也不相等的话，进行赋值操作
        int temp = nums[0];
        // 数组长度只要不为0，最终返回数组长度肯定大于等于1，所以从1开始记录
        int length = 1;
        // 第一版写法，存在的问题，只能取出前面的相同元素，后面元素值相同的都会被移动到数组前面，我们只希望相同的元素只移动一次就够了
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != temp) {
//                nums[length] = nums[i];
//                length++;
//            }
//        }
        // 第二版写法，在进行移动操作的时候，增加了元素的判定
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != temp && nums[i] != nums[i-1]) {
                nums[length] = nums[i];
                length++;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
        return length;
    }

    /**
     * 买卖股票的最佳时机 II
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格，
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        return -1;
    }
}
