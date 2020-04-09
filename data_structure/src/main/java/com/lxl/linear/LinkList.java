package com.lxl.linear;

import java.util.Iterator;

/**
 * 单向链表
 * 头结点不存储元素
 * @param <T>
 */
public class LinkList<T> implements Iterable<T>{

    private Node<T> head;
    private int N;



    class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkList() {
        this.head = new Node(null,null);
        N = 0;
    }

    public void clear(){
        this.head.next = null;
        this.N = 0;
    }

    public int length(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public T get(int i){
        Node<T> n = head.next;
        for(int idx = 0;idx < i;idx++){
            if(n != null)
            n = n.next;
        }
        return n.item;
    }

    public void insert(T t){
        Node<T> n = head;
        while (n.next != null)n = n.next;
        Node node = new Node(t, null);
        n.next = node;
        N++;
    }

    public void insert(int i, T t){
        Node<T> pre = head;
        for(int idx = 0;idx <=i-1;idx++){
            pre = pre.next;
        }
        Node cur = pre.next;
        Node node = new Node(t, cur);
        pre.next = node;
        N++;
    }

    public T remove(int i){
        Node<T> pre = head;
        for(int idx = 0;idx <=i-1;idx++){
            pre = pre.next;
        }
        Node<T> cur = pre.next;
        Node next = cur.next;
        pre.next = next;
        N--;
        return cur.item;
    }

    public int indexOf(T t){
        Node<T> cur = head;
        if(cur != null && cur.item != null){
            for(int i = 0;cur.next != null;i++){
                cur = cur.next;
                if(cur.item.equals(t)){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkIterator();
    }

    private class LinkIterator implements Iterator{
        private Node n;

        public LinkIterator() {
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
        LinkList<String> list = new LinkList();
        list.insert("姚明");
        for(String item : list){
            System.out.println(item);
        }
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
        list.insert(1, "小罗");
        for(String item : list){
            System.out.println(item);
        }

        String s = list.get(0);
        System.out.println(s);
        int index = list.indexOf("姚明");
        System.out.println(index);
        list.remove(1);
        System.out.println(list);
        for(String item : list){
            System.out.println(item);
        }
    }


}
