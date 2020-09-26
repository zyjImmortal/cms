package com.zyj.cms.core.service.geek.aldatastruc.ds.lru;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map;
    private DoubleList cache;
    private int cap;

    public LRUCache(int capacity){
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    /**
     * 添加最近使用的元素
     * @param key
     * @param value
     */
    private void addRecently(int key, int value){
        Node x = new Node(key, value);
         cache.addLast(x);
         map.put(key, x);
    }

    /**
     * 将某个key提升为最近使用，需要将链表里原来的删除再添加到末尾
     * @param key
     */
    private void makeRecently(int key){
        Node x = map.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    /**
     * 删除某个key
     * @param key
     */
    private void deleteKey(int key){
        Node x = map.get(key);
        cache.remove(x);
        map.remove(key);
    }

    /**
     * 移除最久未使用的key
     * 这里就可以看出为什么要在node里面存储key，因为要删除最久未使用的key时，
     * 需要先获取key，才能从map里面删掉
     */
    private void removeLeastRecently(){
        Node x = cache.removeFirst();
        map.remove(x.key);
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return map.get(key).value;
    }

    public void put(int key, int value){
        if (map.containsKey(key)){
            deleteKey(key);
            addRecently(key, value);
            return;
        }
        if (cap == cache.size()){
            removeLeastRecently();
        }
        addRecently(key, value);
    }

}
