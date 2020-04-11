package com.lxl.tree.binaryTree;

import java.util.HashMap;

public class RedBlackTree<K extends Comparable<K>,V> {

    private Node root;
    private int N;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    class Node{
        K key;
        V value;
        Node left;
        Node right;
        boolean color;

        public Node(K key, V value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    public int size(){
        return N;
    }

    private boolean isRed(Node x){
        if(x == null)return false;
        return x.color;
    }

    /**
     * 左旋
     * 当前结点为h，右子结点为r
     * 将h的右子结点变为r的左子节点
     * 将r的左子节点变为h
     * 将r的颜色变为h的颜色
     * 将h的颜色变为红色
     * @param h
     * @return
     */
    private Node rotateLeft(Node h){
        Node r = h.right;
        h.right = r.left;
        r.left = h;
        r.color = h.color;
        h.color = RED;
        return r;
    }

    /**
     * 右旋
     * @param h
     * @return
     */
    private Node rotateRight(Node h){
        //h的左子节点l
        Node l = h.left;
        //h的左子节点指向l的右子结点
        h.left = l.right;
        //l的右子结点指向h
        l.right = h;
        //l的颜色变为h的颜色
        l.color = h.color;
        //h的颜色变为红色
        h.color = RED;
        return l;
    }

    /**
     * 颜色反转
     * @param h
     */
    public void flipColor(Node h){
        //当前结点变为红色
        h.color = RED;
        //左右子结点变为黑色
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public void put(K key, V value){
        put(root, key, value);
        root.color = BLACK;
    }

    public Node put(Node h, K key, V value){
        //判断h是否为空，如果为空则直接返回一个红色的结点
        if(h == null){
            N++;
            return new Node(key,value,null,null,RED);
        }
        //比较h的键与key的大小
        int compareTo = key.compareTo(h.key);
        if(compareTo > 0){
            //向右
            h.right = put(h.right,key,value);
        }else if(compareTo < 0){
            //向左
            h.left = put(h.left, key, value);
        }
        else {
            h.value = value;
        }
        //左旋,右结点为红色，左结点为黑色
        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        //右旋，左子结点为红色，左子结点的左子结点为红色
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        //颜色反转，左右子结点都为红色时，需要颜色反转
        if(isRed(h.left) && isRed(h.right)){
            flipColor(h);
        }
        return h;
    }

    public V get(K key){
        return get(root, key);
    }

    public V get(Node h, K key){
        if(h == null)return null;
        int compareTo = key.compareTo(h.key);
        if(compareTo > 0){
            return get(h.right,key);
        }else if(compareTo < 0){
            return get(h.left, key);
        }else{
            return h.value;
        }
    }

    public static void main(String[] args) {
        RedBlackTree<String, String> tree = new RedBlackTree<>();
        tree.put("A","1");
        tree.put("B","2");
        tree.put("C","3");
        System.out.println();
    }

}
