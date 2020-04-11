package com.lxl.tree.binaryTree;

import com.lxl.linear.queue.QueueByLink;

public class PageFolding {

    /**
     * 对折纸，构成树结构
     * @param n
     * @return
     */
    public static Node createTree(int n){
        if(n < 1)return null;
        Node node = null;
        for(int i = 1;i<=n;i++){
            if(i == 1){
                node = new Node("down" + 1, null, null);
                continue;
            }
            QueueByLink<Node> queue = new QueueByLink();
            queue.enqueue(node);

            while (!queue.isEmpty()){
                Node o = queue.dequeue();
                if(o.left != null)queue.enqueue(o.left);
                if(o.right != null)queue.enqueue(o.right);
                if(o.left == null && o.right == null){
                    o.left = new Node("down" + i,null,null);
                    o.right = new Node("up" + i, null, null);
                }
            }
        }
        return node;
    }

    public static void printTree(Node root){
        if(root == null)return;
        printTree(root.left);
        System.out.println(root.item);
        printTree(root.right);
    }

    public static void main(String[] args) {
        Node tree = createTree(3);
        printTree(tree);
    }

    static class Node{
        String item;
        Node left;
        Node right;

        public Node(String item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
