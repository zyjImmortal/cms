package com.zyj.cms.core.service.geek.aldatastruc.ds.lru;

import java.util.LinkedHashMap;

public class LRUCacheLinkedHashMap {
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCacheLinkedHashMap(int cap) {
        this.cap = cap;
    }

    private void makeRecently(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);

    }

    public int get(int key){
        if (!cache.containsKey(key)){
            return -1;
        }
        makeRecently(key);
        return cache.get(key);
    }

    public void put(int key, int value){
        if (cache.containsKey(key)){
            cache.put(key,value);
            makeRecently(key);
            return;
        }
        if (cache.size() >= this.cap){
            int oldestKey = cache.keySet().iterator().next();
            cache.remove(oldestKey);
        }
        cache.put(key,value);
    }
}
