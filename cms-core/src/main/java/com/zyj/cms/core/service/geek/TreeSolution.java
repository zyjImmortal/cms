package com.zyj.cms.core.service.geek;

/**
 * Author: zhouyajun
 * Date: 2019-07-15
 */
public class TreeSolution {

    /**
     * 判断一颗二叉树是否是镜像对称的
     *
     * @param root 根节点
     * @return true是，false不是
     *
     * 思路：一棵树和自己镜像堆成，则它本身镜像对称
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
