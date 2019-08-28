package com.lxl.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 树的遍历
 *
 * 栈：
 *  Stack和LinkedList都实现了栈的功能
 *  分别使用了数组 和 链表实现；
 *  鉴于数组和链表的区别：数组操作最后元素较方便，链表操作首元素较方便
 *  因此Stack的pop和push操作的是数组的len-1元素
 *      LinkedList的pop和push操作的是数组的first元素
 */
public class TreeTraversal {

    /**
     * 一 ，前序遍历
     */
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

    /**
     * 非递归实现前序遍历
     * 借助栈
     * @param root
     */
    public void preOrderTraversal2(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curNode = root;
        while (curNode != null || stack != null){
            if(curNode != null){
                System.out.println(curNode.val + " ");
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                TreeNode pop = stack.pop();
                curNode = curNode.right;
            }
        }
    }

    /**
     * 二，中序遍历
     */
    /**
     * 非递归实现
     */
    public void midOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curNode = root;
        while (curNode != null || stack != null){
            if(curNode != null){
                stack.push(curNode);
                curNode = curNode.left;
            }else{
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                curNode = curNode.right;
            }
        }
    }
    /**
     * 三，后序遍历
     */

    /**
     * 层次遍历
     * 使用队列
     */
    public void levelTraversal(TreeNode root){
        if(root == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (queue != null){
            TreeNode poll = queue.poll();
            System.out.println(poll.val);
            if(poll.left != null){
                queue.add(poll.left);
            }
            if(poll.right != null){
                queue.add(poll.right);
            }
        }

    }
}
