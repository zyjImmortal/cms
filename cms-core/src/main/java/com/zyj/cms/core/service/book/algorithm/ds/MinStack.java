package com.zyj.cms.core.service.book.algorithm.ds;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhouyajun
 * @date 2019/4/16
 */
public class MinStack {

    private Queue<Integer> statck;
    private Integer minValue;

    public MinStack(){
        statck = new LinkedList<Integer>();
    }

    public void push(int x){

    }

    public void pop() {
        statck.peek();
    }

    public int top() {
        return -1;
    }

    public int getMin() {
        return -1;
    }
}
