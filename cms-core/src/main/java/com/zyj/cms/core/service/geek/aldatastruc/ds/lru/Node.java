package com.zyj.cms.core.service.geek.aldatastruc.ds.lru;

public class Node {
    public int key;
    public int value;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.value = v;
    }
}
