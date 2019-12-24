package com.zyj.cms.core.service.geek.AlAndDataStruc.ds.queue;

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

    /**
     * 入队的时候集中触发一次数据搬移操作
     *
     * @param item 入队元素
     * @return true 入队成功，false 入队失败
     */
    public boolean enqueueV2(String item) {
        if (tail == n) {
            // tail=n.head=0,说明队列已满，无法入队
            if (head == 0) {
                return false;
            }
            if (tail - head >= 0) {
                System.arraycopy(items, head, items, 0, tail - head);
            }
            tail = tail - head;
            head = 0;
        }
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
