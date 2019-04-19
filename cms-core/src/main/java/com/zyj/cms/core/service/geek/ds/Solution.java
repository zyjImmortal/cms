package com.zyj.cms.core.service.geek.ds;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
 * 请注意，它是排序后的第k小元素，而不是第k个元素
 *
 * @author zhouyajun
 * @date 2019/4/18
 */
public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int[] ints : matrix) {
            for (Integer value : ints) {
                if (queue.size() < k) {
                    queue.add(value);
                    continue;
                }
                if (value > queue.peek()) {
                    // todo
                    continue;
                }
                queue.poll();
                queue.add(value);

            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(6, new Comparator<Integer>() {
//            public int compare(Integer o1, Integer o2) {
//                if (o1 < o2){
//                    return 1;
//                }else if (o1 > o2){
//                    return -1;
//                }else {
//                    return 0;
//                }
//            }
//        });
//
//        int[] nums = {2,1,3,4,5,6,4,5,6,4,7,8,89};
//        for (int i = 0; i < nums.length; i++) {
//            queue.add(nums[i]);
//        }
//        System.out.println(queue.toString());
//
//        while (queue.peek() != null){
//            System.out.println(queue.poll() + " ");
//        }

        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(matrix, 8));
    }
}
