package com.zyj.cms.core.service.geek.aldatastruc.ds.lru;


/**
 * 双向列表
 */
public class DoubleList {
    private Node head, tail;
    private int size;

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 在列表尾部添加节点
     *
     * @param x
     */
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }

    /**
     * 删除链表中的x节点，该节点一定是存在的
     * 由于是双向链表且给定的是目标节点，所以删除是O(1),如果是目标节点的值，要遍历
     * @param x
     */
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    /**
     * 移除链表首节点
     *
     * @return
     */
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        return first;
    }

    public int size() {
        return size;
    }
}
