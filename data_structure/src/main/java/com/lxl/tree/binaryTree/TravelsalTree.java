package com.lxl.tree.binaryTree;

import java.util.Stack;

/**
 * 非递归方式实现遍历树
 *
 */
public class TravelsalTree {

    /**
     * 先序遍历
     * root入栈，出栈后把右结点，左结点入栈
     * @param root
     */
    public void preErgodic(BinaryTree.Node root){
        Stack<BinaryTree.Node> stack = new Stack();
        BinaryTree.Node node = root;
        stack.push(node);
        while (!stack.isEmpty()){
            BinaryTree.Node pop = stack.pop();
            System.out.println(pop);
            if(pop.right != null)
                stack.push(pop.right);
            if(pop.left != null)
                stack.push(pop.left);
        }
    }

    /**
     * 中序遍历
     * 左-根-右
     * 有左结点，则一直向左压栈
     * 没有左结点，出栈，转移到右结点
     * @param root
     */
    public void midErgodic(BinaryTree.Node root){
        if(root != null){
            Stack<BinaryTree.Node> nodes = new Stack<>();
            BinaryTree.Node node = root;
            while (!nodes.isEmpty() || node != null){
                if(node != null){
                    nodes.push(node);
                    node = node.left;
                }else{
                    node = nodes.pop();
                    System.out.println(node.value);
                    node = node.right;
                }
            }
        }
    }

    /**
     * 后序遍历(使用额外栈)
     * 中左右变到 中右左
     * 此时不打印，使用额外栈接收，最后弹出打印
     * @param node
     */
    public void afterErgodic(BinaryTree.Node node){
        if(node != null){
            Stack<BinaryTree.Node> s1 = new Stack<>();
            Stack<BinaryTree.Node> s2 = new Stack<>();
            s1.push(node);
            while (!s1.isEmpty()){
                BinaryTree.Node pop = s1.pop();
                s2.push(pop);
                if(pop.left != null){
                    s1.push(pop.left);
                }
                if(pop.right != null){
                    s1.push(pop.right);
                }
            }
            while (!s2.isEmpty()){
                System.out.println(s2.pop().value);
            }
        }
    }

    /**
     * 后序遍历  -不使用额外栈空间
     * 结点有左子结点且上次打印的不是左右子结点，则左子结点入栈
     * 结点有右子结点，且上次打印的不是右子结点，右子结点入栈
     * 其他情况，打印结点，并记录打印结点
     * @param node
     */
    public void afterErgodic2(BinaryTree.Node node){
        if(node != null){
            Stack<BinaryTree.Node> stack = new Stack<>();
            stack.push(node);
            BinaryTree.Node cur = null;
            BinaryTree.Node pre = node;
            while (!stack.isEmpty()){
                cur = stack.peek();
                //左子结点存在，且上次未打印左右子结点
                if(cur.left != null && pre != cur.left && pre != cur.right){
                    stack.push(cur.left);
                    //右子结点存在，且上次未打印右子结点
                }else if(cur.right != null && pre != cur.right){
                    stack.push(cur.right);
                }else {
                    System.out.println(stack.pop());
                    pre = cur;
                }
            }
        }
    }

    /**
     * 递归做法：当前结点，处理左子结点，当前结点，处理右子结点，当前结点
     *          递归做法，三次回到自身结点，因此打印可以有三个时机
     * morris遍历
     *      当前是否有左孩子
     *          有，左孩子的最右结点的右指针是否指向当前结点
     *                  没有，指向当前结点，向左移动
     *                  有，指向空，向右移动
     *          没有，当前结点向右移动
     * morris遍历除了叶子节点，会两次回到当前结点
     *则，先序遍历，中序遍历分别在第一次和第二次回到自己的时候打印即可
     *
     * 后序遍历
     * 在第二次回到自己时，逆序打印
     */
    public void morrisPre(BinaryTree.Node root){
        if(root == null)return;
        BinaryTree.Node node = root;
        BinaryTree.Node left = null;
        while (node != null){
            left = node.left;
            if(left != null){
                while (left.right != null && left.right != node){
                    left = left.right;
                }
                if(left.right == null){
                    left.right = node;
                    System.out.println(node.value);//左子结点的最右子结点的右指向为空，第一次走到node
                    node = node.left;
                    continue;
                }else {
                    left.right = null;
                    //中序遍历时，在此打印
                    //System.out.println(node.value);//左子结点的最右子结点的右指向不为空，第二次回到自己
                    node = node.right;
                }
            }else{
                node = node.right;
            }
        }
    }

    public void morrisAfter(BinaryTree.Node root){
        if(root == null)return;
        BinaryTree.Node node = root;
        BinaryTree.Node left = null;
        while (node != null){
            left = node.left;
            if(left != null){
                while (left.right != null && left.right != node){
                    left = left.right;
                }
                if(left.right == null){
                    left.right = node;
                    node = node.left;
                    continue;
                }else {
                    left.right = null;
                    //逆序打印当前结点的左子树的右边界
                    printRightEdge(node.left);
                    node = node.right;
                }
            }else{
                node = node.right;
            }
            printRightEdge(node);//打印最右边界
        }
    }

    public void printRightEdge(BinaryTree.Node node){
        BinaryTree.Node reverse = reverse(node);
        BinaryTree.Node tail = reverse;
        while (tail != null){
            System.out.println(tail.value);
            tail = tail.right;
        }
        reverse(reverse);
    }

    public BinaryTree.Node reverse(BinaryTree.Node node){
        BinaryTree.Node pre = null;
        BinaryTree.Node cur = node;
        BinaryTree.Node next = null;
        while (cur != null){
            next = cur.right;
            cur.right = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
