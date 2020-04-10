package com.lxl.linear.stack;

import java.util.Iterator;

/**
 * 使用链表实现栈
 *头结点不存数据
 *  push放在头结点next，修改指针指向
 * @param <T>
 */
public class StackByLink<T> implements Iterable<T>{

    private Node head;
    private int N;

    class Node{
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public StackByLink() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(T t){
        Node next = head.next;
        Node node = new Node(t, next);
        head.next = node;
        N++;
    }

    public T peek(){
        if(isEmpty()) return null;
        return head.next.item;
    }

    public T pop(){
        if(isEmpty())return null;
        Node node = head.next;
        head.next = node.next;
        N--;
        return node.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator {
        private Node node;

        public StackIterator() {
            this.node = head;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        StackByLink<String> stack = new StackByLink();
        stack.push("大罗");
        stack.push("C罗");
        stack.push("小罗");
        for(String item : stack){
            System.out.println(item);
        }

        String pop = stack.pop();
        System.out.println(pop);

        for(String item : stack){
            System.out.println(item);
        }

        System.out.println(stack.size());
        System.out.println(stack.peek());
    }
}
