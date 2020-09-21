package com.zyj.cms.core.service.geek.aldatastruc.ds.listnode;


/**
 * @author : zhouyajun
 * @date : 2020/9/6
 */
public class ListNode {

    private Node head;
    private int length;

    public ListNode(Object data) {
        this.head = new Node(data);
        this.length = 1;
    }

    /**
     * 添加一个列表
     *
     * @param data
     */
    public void addNode(Object data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        this.length++;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("列表长度为0");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.next;
        }

    }

    public int length() {
        return this.length;
    }

    public void insertNode(int index, Object data) {
        if (index < 1 || index > length + 1) {
            System.out.println(String.format("插入的位置不合法,应该在1-%d的范围内", this.length));
            return;
        }
        Node temp = head;
        int currentPos = 0;
        //初始化要插入的节点
        Node insertNode = new Node(data);
        while (temp.next != null) {
            //找到上一个节点的位置了
            if ((index - 1) == currentPos) {
                //temp表示的是上一个节点
                //将原本由上一个节点的指向交由插入的节点来指向
                insertNode.next = temp.next;
                //将上一个节点的指针域指向要插入的节点
                temp.next = insertNode;
                return;
            }
            currentPos++;
            temp = temp.next;

        }
    }

    /**
     * 删除指定位置的节点
     *
     * @param index
     */
    public void delete(int index) {

        //首先需要判断指定位置是否正确，
        if (index < 1 || index > length() + 1) {
            System.out.println("下标校验不通过。");
            return;
        }

        //临时节点，从头节点开始
        Node temp = head;

        //记录遍历的当前位置
        int currentPos = 0;

        while (temp.next != null) {
            //先找到要删除节点 上一个节点的位置

            if (index - 1 == currentPos) {
                //temp 表示要删除的节点

                //temp.next表示的是想要删除的节点

                //将想要删除的节点存储一下
                Node deleteNode = temp.next;
                //把想要删除的下一个节点由上一个节点交互
                temp.next = deleteNode.next;


                return;

            }

            currentPos++;
            temp = temp.next;

        }


    }


    public Object getOne(int index) {
        //首先需要判断指定位置是否正确，
        if (index < 1 || index > length()) {
            System.out.println("下标校验不通过");
            return null;
        }

        //临时节点
        Node temp = head;


        //记录遍历的当前位置
        int currentPos = 1;

        while (temp != null) {

            if (index == currentPos) {
                return temp.getData();
            }
            currentPos++;
            temp = temp.next;

        }

        return null;

    }

}
