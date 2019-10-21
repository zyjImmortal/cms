package com.zyj.cms.core.service.geek.sort;


import java.util.Arrays;

/**
 * 排序算法           时间复杂度   是否基于比较实现
 * 冒泡，插入、选择     O(n**2)          是
 * 快速排序、归并排序    O(nlogn)        是
 * 桶、计数、基数        O(n)           不是
 * <p>
 * 问题：插入排序和冒泡排序的时间复杂度相同，为什么在实际软件开发中插入排序更常用
 * 因为冒泡排序的元素位置交换更多
 * <p>
 * 如何分析一个排序算法？
 * 算法的执行效率：
 * 1、最好情况、最坏情况、平均情况时间时间复杂度：数据的有序程度对不同算法的执行时间有很大影响
 * 2、时间复杂度的洗漱、常数、低阶
 * 3、比较次数和交换(移动次数)次数
 * <p>
 * 排序算法的内存消耗：
 * 空间复杂度
 * 原地排序：空间复杂度为O(1)的算法，比如说交换位置
 * <p>
 * <p>
 * 排序算法的稳定性：
 * 稳定性。这个概念是说，如果待排序的序列中存在值相等的元素，经过排序之后，相等元素之间原有的先后顺序不变，
 * 举例：对订单按金额大小排序，金额相同的按照下单时间排序，实现思路：先按时间排序，再用稳定排序算法对金额进行排序
 */
public class BubbleInsertSelectSort {

    /**
     * 冒泡排序：只会操作相邻的两个元素，每次冒泡都会对相邻的两个元素进行比较，看是否满足大小关系，如果不满足就互换
     * 一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了1个数据的排序工作
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            boolean flag = false;  // 标记是否有数据交换。如果在某一次循环过程中没有交换数据，则退出循环
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }

    }

    /**
     * 插入排序：区分已排序区间和未排序区间，每次从未排序区间拿一个元素插入到已排序区间，
     * 思路：外层循环拿元素，内层循环找到合适的位置j，然后内层循环结束后插入元素
     *
     * 插入排序是原地排序的算法，不需要额外的存储空间，只有一个移动位置的操作，空间复杂度是O(1)
     * 是稳定的排序算法，对于相同的元素插入到了前面出现过元素的后面
     * @param nums
     * @return
     */
    public static int[] insertSort(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        for (int i = 1; i < nums.length; i++) {
            int value = nums[i]; // 去未排序区间的第一个元素
            int j = i - 1;
            // 对于已排序区间，从后往前查找合适的位置
            // java的for循环是执行完循环体以后再执行j--的操作，当j=0的时候满足条件进行交换操作以后j=-1了
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
        return nums;
    }

    /**
     * 选择排序：区分已排序区间和未排序区间，每次从未排序区间选择一个最小的，放在已排序区间的末尾
     *
     * 选择排序不够稳定，排序的过程中会改变相同元素的位置
     *
     * @param nums
     */
    public static int[] selectSort(int[] nums) {
        if (nums.length < 1) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            int min = nums[minIndex];
            // 找出未排序区间最小值所在的位置
            for (int j = i; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            // 放到已排序区间最后的位置：已排序区间最后的位置就是未排序区间的第一个位置，和这个位置的元素交换位置就可以
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 0, 5, 2,0,5};
        System.out.println(Arrays.toString(BubbleInsertSelectSort.insertSort(nums)));
    }
}
