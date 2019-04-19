package com.zyj.cms.core.service.geek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public static void main(String[] args) {
        int x = 121;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(x));
    }
}
