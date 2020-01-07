package com.zyj.cms.core.service.geek.aldatastruc.ds.listnode;

/**
 * @author : zhouyajun
 * @date : 2020-01-07
 */
public class LRUBaseLinkedList<T> {
    private final static Integer DETAULT_CAPACITY = 10;
    private Integer length;
    private Integer capacity;
    private Node<T> headNode;

    public LRUBaseLinkedList(){
        this(DETAULT_CAPACITY);
    }

    public LRUBaseLinkedList(int capacity){
        this.capacity = capacity;
        this.headNode = new Node<>();
        this.length = 0;
    }

    private Node findPreNode(T data){
        Node node = headNode;
        while (node.getNext() != null){
            if (data.equals(node.getNext().getElement())){
                return node;
            }
        }
        return null;
    }


    class Node<T> {
        private T element;
        private Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node() {
            this.next = null;
        }

        public Node(T element) {
            this.element = element;
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public void setElement(T element) {
            this.element = element;
        }
    }
}
