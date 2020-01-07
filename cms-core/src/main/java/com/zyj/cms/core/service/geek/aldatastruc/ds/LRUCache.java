package com.zyj.cms.core.service.geek.aldatastruc.ds;

import java.util.LinkedList;

/**
 * @author: zhouyajun
 * @date: 2020-01-07
 */
public class LRUCache {

    private int capacity;
    private int size;
    private LinkedList<ListNode> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        cache = new LinkedList<ListNode>();
    }

    public int get(int key) {
        if (cache.get(key) != null){
            ListNode node = cache.remove(key);
            cache.addFirst(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (size == capacity){
            cache.removeLast();
        }
        cache.set(key,new ListNode(value));
    }
}
