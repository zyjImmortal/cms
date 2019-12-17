package com.zyj.cms.core.service.geek.AlAndDataStruc.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhouyajun
 * @date 2019/4/18
 */
public class SortSolution {

    /**
     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if ((o2 + o1).compareTo(o1 + o2) > 0) {
                    return 1;
                } else if ((o2 + o1).compareTo(o1 + o2) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        StringBuilder builder = new StringBuilder();
        for (String str : strings) {
            builder.append(str);
        }
        return "0".equals(strings[0]) ? "0" : builder.toString();
    }


    /**
     * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序
     * @param nums
     */
    public void wiggleSort(int[] nums) {

    }

    public static void main(String[] args) {
        SortSolution sortSolution = new SortSolution();
        int[] nums = {3, 30, 34, 5, 9};
        int[] nums2 = {0,0,0};
        System.out.println(sortSolution.largestNumber(nums2));
    }
}
