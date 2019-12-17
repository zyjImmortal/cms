package com.zyj.cms.core.service.geek.AlAndDataStruc.ds;

/**
 * Author: zhouyajun
 * Date: 2019-12-10
 */
public class ArrayQueue {
    private String[] items;
    private int head;
    private int tail = 0;
    private int n = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String tmp = items[head];
        head++;
        return tmp;
    }
}
