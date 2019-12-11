package com.zyj.cms.core.service.geek.solutions;

import java.util.*;

/**
 * @author zhouyajun
 * @date 2019/4/19
 */
public class Solution {

    public boolean isPalindrome(int x) {
        Stack<Integer> reverse = new Stack<Integer>();
        Queue<Integer> order = new LinkedList<Integer>();
        if (x < 0) {
            return false;
        }
        while ((x / 10) != 0) {
            int mod = x % 10;
            reverse.push(mod);
            order.add(mod);
            x = x / 10;
        }
        reverse.push(x);
        order.add(x);
        while (!reverse.isEmpty() && !order.isEmpty()) {
            if (!reverse.peek().equals(order.peek())) {
                return false;
            }
            reverse.pop();
            order.remove();
        }
        return true;

    }

    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        HashMap<Character, Character> mapper = new HashMap<Character, Character>();
        mapper.put(')', '(');
        mapper.put('}', '{');
        mapper.put(']', '[');
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || mapper.values().contains(s.charAt(i))) {
                stack.push(s.charAt(i));
                continue;
            }

            if (mapper.get(s.charAt(i)).equals(stack.peek())) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        return stack.isEmpty();
    }

    /**
     * 合并两个有序数组
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] results = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                results[i] = nums1[i];
                i++;
            } else {
                results[k] = nums2[j];
                j++;
            }
            k++;
        }
        if (i + 1 != m) {
            for (int l = i + 1; l < m; l++) {
                results[k + 1] = nums1[l];
                k++;
            }
        }
        if (j + 1 != n) {
            for (int l = j + 1; l < n; l++) {
                results[k + 1] = nums2[2];
                k++;
            }
        }
        nums1 = results;
    }

    private void copy(int[] from, int fromStart, int fromEnd, int toStart, int toEnd) {
        for (int i = fromEnd, j = toEnd; i >= fromStart && j >= toStart; i--, j--) {
            from[j] = from[i];
        }
    }

    public void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, count = 0;
        while (i < m + n && j < n) {
            if (nums1[i] <= nums2[j] && i < m + count) {
                i++;
            } else if (i >= m + count) {
                nums1[i] = nums2[j];
                count++;
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                copy(nums1, i, m - 1 + count, i + 1, m + count);
                nums1[i] = nums2[j];
                count++;
                i++;
                j++;
            }

        }
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 示例:
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     * 思路：只要和是大于0说明仍然是增加的可以继续加，如果加了一个元素小于0了，就重置
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum = sum + num;
            } else {
                sum = num;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    /**
     * 动态规划的问题
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数
     *
     * @param n
     */
    public int climbStairs(int n) {
        // 备忘录的方式存储计算过的子状态
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int value = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, value);
            return value;
        }
    }

    public int climbStairsV2(int n){
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // 第三个状态等于前两个状态之和
        // 至底向上，只保留前两个状态，第三个状态由前两个状态得出
        int a = 1;
        int b = 2;
        int temp = 0;
        for (int i = 3; i <=n ; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    /**
     * 使用最小花费爬楼梯
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        return -1;
    }

    public static void main(String[] args) {
//        int x = 121;
        String s = "()[]{}";
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {2, 5, 6};
        Solution solution = new Solution();
//        solution.mergeV2(nums1, 3, nums2, 3);
        System.out.println(solution.maxSubArray(nums1));
//        System.out.println(solution.isValid(s));
    }
}
