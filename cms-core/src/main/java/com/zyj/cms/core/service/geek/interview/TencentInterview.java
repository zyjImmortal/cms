package com.zyj.cms.core.service.geek.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: zhouyajun
 * Date: 2019-07-29
 */
public class TencentInterview {
    public int minSteps(int n) {

        return 0;
    }

    public static int numSubarraysWithSum(int[] A, int S) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i; j < A.length; j++) {
                int cur = 0;
                for (int k = i; k < j + 1; k++) {
                    cur += A[i];
                }
                if (cur == S) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int numSubarraysWithSumV2(int[] A, int S){
        int count = 0, length = A.length;

        for (int i = 0; i < length; i++) {
            int res = 0;
            for (int j = i; j < length; j++) {
                res += A[j];
                if (res == S){
                    count++;
                }
            }
        }
        return count;
    }

    private static int sum(List<Integer> list) {
        int res = 0;
        for (Integer integer : list) {
            res += integer;
        }
        return res;
    }

    private static void subArray(int[] nums, int i, List<List<Integer>> res, List<Integer> temp) {
        res.add(new ArrayList<Integer>(temp));
        for (int j = i; i < nums.length; i++) {
            temp.add(nums[i]);
            subArray(nums, j + 1, res, temp);
//            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1};
        System.out.println(TencentInterview.numSubarraysWithSumV2(nums, 2));
    }
}
