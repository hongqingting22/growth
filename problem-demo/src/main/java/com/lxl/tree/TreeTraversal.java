package com.lxl.tree;

/**
 * 树的遍历
 */
public class TreeTraversal {
    /**
     * 递归实现前序遍历(前中后序遍历，只需修改打印位置即可)
     */
    public void preOrderTraversal(TreeNode root){
        if(root != null){
            System.out.println(root.val + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
}
