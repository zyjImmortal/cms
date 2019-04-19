package com.zyj.cms.core.service.book.logic.container;

import java.util.LinkedList;

/**
 * @author zhouyajun
 * @date 2019/4/15
 */
public class LinkedListDemo {
    /**
     *LinkedList还实现了队列接口Queue，所谓队列就类似于日常生活中的各种排队，特点就是先进先出，在尾部添加元素，从头部删除元素
     * Queue扩展了Collection，它的主要操作有三个：
     *
     * 在尾部添加元素 (add, offer)
     * 查看头部元素 (element, peek)，返回头部元素，但不改变队列
     * 删除头部元素 (remove, poll)，返回头部元素，并且从队列中删除
     * 每种操作都有两种形式，有什么区别呢？区别在于，对于特殊情况的处理不同。特殊情况是指，队列为空或者队列为满，为空容易理解，为满是指队列有长度大小限制，
     * 而且已经占满了。LinkedList的实现中，队列长度没有限制，但别的Queue的实现可能有。
     *
     * 在队列为空时，element和remove会抛出异常NoSuchElementException，而peek和poll返回特殊值null，在队列为满时，add会抛出异常IllegalStateException，而offer只是返回false
     *
     * 如果列表长度未知，添加、删除操作比较多，尤其经常从两端进行操作，而按照索引位置访问相对比较少，则LinkedList就是比较理想的选择
     *
     * LinkedList是一个List，但也实现了Deque接口，可以作为队列、栈和双端队列使用。实现原理上，内部是一个双向链表，并维护了长度、头节点和尾节点
     */
    private LinkedList<String> linkedList = new LinkedList<String>();

    public static void main(String[] args) {

    }
}
