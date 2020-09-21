package com.zyj.cms.core.service.geek.aldatastruc.ds.listnode;

/**
 * @author : zhouyajun
 * @date : 2020/9/6
 */
public class Node {

    private Object data;
    public Node next;

    public Node(Object data){
        this.data = data;
        this.next = null;
    }

    public Node(Object data, Node next){
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public Node setData(Object data) {
        this.data = data;
        return this;
    }
}
