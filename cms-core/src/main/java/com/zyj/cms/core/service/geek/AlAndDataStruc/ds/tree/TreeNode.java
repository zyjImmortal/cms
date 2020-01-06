package com.zyj.cms.core.service.geek.AlAndDataStruc.ds.tree;

/**
 * @author: zhouyajun
 * @date: 2020-01-02
 */
public class TreeNode<T> {
    private T data;
    private TreeNode<T> leftChild;
    private TreeNode<T> rightChild;

    public TreeNode (T data){
        this(null, data, null);
    }

    public TreeNode(TreeNode<T> leftChild,T data, TreeNode<T> rightChild){
        this.leftChild = leftChild;
        this.data = data;
        this.rightChild = rightChild;
    }

    public T getData(){
        return data;
    }

    public TreeNode<T> getLeftChild(){
        return leftChild;
    }

    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public void setLeftChild(TreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    private void visitNode(TreeNode node){
        System.out.println(node.getData().toString());
        System.out.println(" ");;
    }

    /**
     * 构建二叉树
     *
     * @return 树根
     */
    public TreeNode CreateTree() {
        TreeNode<String> nodeH = new TreeNode<String>("H");
        TreeNode<String> nodeG = new TreeNode<String>("G");

        TreeNode<String> nodeF = new TreeNode<String>(nodeH, "F", null);
        TreeNode<String> nodeE = new TreeNode<String>(nodeG, "E", null);
        TreeNode<String> nodeD = new TreeNode<String>("D");

        TreeNode<String> nodeC = new TreeNode<String>(null, "C", nodeF);
        TreeNode<String> nodeB = new TreeNode<String>(nodeD, "B", nodeE);
        TreeNode<String> nodeA = new TreeNode<String>(nodeB, "A", nodeC);
        return nodeA;
    }

    public void preTraversal(TreeNode node){
        if (node != null){
            visitNode(node);
            preTraversal(node.leftChild);
            preTraversal(node.rightChild);
        }
    }

    public void traversal(TreeNode node){
        if (node != null){
            traversal(node.leftChild);
            visitNode(node);
            traversal(node.rightChild);
        }
    }

    public void postTraversal(TreeNode node){
        if (node != null){
            traversal(node.leftChild);
            traversal(node.rightChild);
            visitNode(node);
        }
    }




}