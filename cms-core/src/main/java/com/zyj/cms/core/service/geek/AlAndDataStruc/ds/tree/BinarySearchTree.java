package com.zyj.cms.core.service.geek.AlAndDataStruc.ds.tree;

/**
 * @author : zhouyajun
 * @date : 2020-01-02
 */
public class BinarySearchTree {
    private TreeNode<Integer> tree;

    public TreeNode find(int data){
        TreeNode<Integer> temp = tree;
        while (temp != null){
            if (data < temp.getData()){
                temp = temp.getLeftChild();
            }else if (data > temp.getData()){
                temp = temp.getRightChild();
            }else {
                return temp;
            }
        }
        return null;
    }

    public void insert(int data){
        if (tree == null){
            tree = new TreeNode<Integer>(data);
            return;
        }
        TreeNode temp = tree;
        while (temp != null){
            if (data > (Integer) temp.getData()){
                if (temp.getRightChild() == null){
                    temp.setRightChild(new TreeNode(data));
                    return;
                }
                temp = temp.getRightChild();
            }
            else {
                if (temp.getLeftChild() == null){
                    temp.setLeftChild(new TreeNode(data));
                    return;
                }
                temp = temp.getLeftChild();
            }
        }
    }


}
