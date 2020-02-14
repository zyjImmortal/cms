package com.zyj.cms.core.service.geek.aldatastruc.ds;

import java.util.Stack;

/**
 * @author zhouyajun
 * @date 2019/4/16
 */
public class MinStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MinStack() {
        // 维护元素的添加顺序
        stack1 = new Stack<Integer>();
        // 维护一个最小值
        stack2 = new Stack<Integer>();
    }

    public void push(int x) {
        // 等于是必须的，
        if (stack2.isEmpty() || stack2.peek() >= x) {
            stack2.push(x);
        }
        stack1.push(x);
    }

    public void pop() {
        if (stack1.peek().equals(stack2.peek())) {
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 5, 6};
        MinStack minStack = new MinStack();
        for (int i = 0; i < nums.length; i++) {
            minStack.push(nums[i]);
        }

        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.push(0);
        System.out.println(minStack.top());
    }
}
