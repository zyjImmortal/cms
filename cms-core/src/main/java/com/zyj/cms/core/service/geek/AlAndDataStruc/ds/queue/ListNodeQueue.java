package com.zyj.cms.core.service.geek.AlAndDataStruc.ds.queue;

/**
 * @author: zhouyajun
 * @date: 2019-12-23
 */
public class ListNodeQueue<E> {
    private ListNode<E> head;
    private ListNode<E> tail;
    private int count;

    public ListNodeQueue(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public boolean enqueue(E item) {
        return false;
    }

    class ListNode<T> {
        public T val;
        public ListNode next;

        ListNode(T val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        ListNode(T val) {
            this.val = val;
            this.next = null;
        }
    }
}
