package com.lxl.linear;

import java.util.Iterator;

/**
 * 双向链表 每个节点包含指向前节点和指向后节点的指针
 * 头结点不存储元素
 * get O(n)
 * insert O(n)   不需要移动元素
 * remove O(n)
 * @param <T>
 */
public class TowLinkList<T> implements Iterable<T>{
    private Node head;
    private Node tail;
    private int N;

    public TowLinkList() {
        this.head = new Node(null,null,null);
        this.tail = null;
        this.N = 0;
    }



    class Node{
        Node pre;
        Node next;
        T item;

        public Node(Node pre, Node next, T item) {
            this.pre = pre;
            this.next = next;
            this.item = item;
        }
    }

    public void clear(){
        this.head.next = null;
        this.head.pre = null;
        this.head.item = null;
        this.tail = null;
        this.N = 0;
    }

    public int length(){
        return N;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public T getFirst(){
        if(isEmpty())return null;
        return head.next.item;
    }

    public T getLast(){
        if(isEmpty())return null;
        return tail.item;
    }

    public void insert(T t){
        if(isEmpty()){
            Node node = new Node( head, null, t);
            tail = node;
            head.next = tail;
        }else{
            Node oldTail = tail;
            //新节点的pre为尾结点
            Node node = new Node(oldTail, null, t);
            //尾结点的next为新节点
            oldTail.next = node;
            //新节点作为尾结点
            tail = node;
        }
        N++;
    }

    public void insert(int i ,T t){
        //找到i位置前一个节点
        Node pre = head;
        for(int idx = 0;idx <= i - 1;idx++){
            pre = pre.next;
        }
        //找到当前i位置的节点，记为当前节点
        Node cur = pre.next;
        //新建节点，pre为前一个节点，next为当前节点
        Node newNode = new Node(pre, cur, t);
        //前一个节点的next指向新建节点
        pre.next = newNode;
        //当前节点的pre指向新建节点
        cur.pre = newNode;
        //元素个数加一
        N++;
    }

    public T get(int i){
        //找到i位置前一个节点
        Node pre = head.next;
        for(int idx = 0;idx <= i - 1;idx++){
            pre = pre.next;
        }
        return pre.item;
    }

    public int indexOf(T t){
        Node pre = head;
        for(int i = 0;pre.next != null;i++){
            pre = pre.next;
            if(pre.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    public T remove(int i){
        //找到i位置前一个节点
        Node pre = head;
        for(int idx = 0;idx <= i - 1;idx++){
            pre = pre.next;
        }
        //i位置节点
        Node cur = pre.next;
        //i位置后节点
        Node next = cur.next;
        //前节点的next指向后节点
        pre.next = next;
        //后节点的pre指向前节点
        next.pre = pre;
        //长度-1
        N--;
        return cur.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator{
        private Node n;

        public TIterator() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        TowLinkList<String> list = new TowLinkList();
        list.insert("姚明");
        for(String item : list){
            System.out.println(item);
        }
        System.out.println("------------------------");
        list.insert(0, "科比");
        list.insert(1, "麦迪");
        list.insert(0, "C罗");
        list.insert(1, "梅西");
        list.insert(0, "伊布");
        list.insert(1, "卡卡");
        list.insert(0, "大罗");
        for(String item : list){
            System.out.println(item);
        }
        System.out.println("------------------------");
        list.insert(1, "小罗");
        for(String item : list){
            System.out.println(item);
        }
        System.out.println("------------------------");

        String s = list.get(0);
        System.out.println(s);
        int index = list.indexOf("姚明");
        System.out.println(index);
        list.remove(1);
        for(String item : list){
            System.out.println(item);
        }
        System.out.println("------------------------");
        String first = list.getFirst();
        System.out.println(first);
        System.out.println(list.getLast());

    }
}
