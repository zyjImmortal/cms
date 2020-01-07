package com.zyj.cms.core.service.geek.aldatastruc.ds.queue;

/**
 * 循环队列
 *
 * @author : zhouyajun
 * @date : 2019-12-23
 */
public class CircularQueue {
    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        // 循环队列会浪费掉一个储存空间
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(5 % 7);
    }
}
