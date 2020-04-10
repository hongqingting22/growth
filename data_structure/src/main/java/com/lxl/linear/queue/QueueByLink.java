package com.lxl.linear.queue;

import java.util.Iterator;

public class QueueByLink<T> implements Iterable<T>{

    private Node head;
    private Node last;
    private int N;

    class Node{
        private T item;
        private Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public QueueByLink() {
        this.head = new Node(null, null);
        this.last = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }

    public void enqueue(T t){
        if(isEmpty()){
            last = new Node(t, null);
            head.next = last;
        }else{
            Node node = new Node(t, null);
            last.next = node;
            last = node;
        }
        N++;
    }

    public T dequeue(){
        if(isEmpty())return null;
        Node node = head.next;
        head.next = node.next;
        N--;
        return node.item;
    }

    public T peek(){
        if(isEmpty())return null;
        return head.next.item;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("QueueByLink:");
        for (T item: this) {
            str.append(item).append("->");
        }
        return str.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator{
        private Node node;

        public QueueIterator() {
            this.node = head;
        }

        @Override
        public void remove() {

        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = this.node.next;
            return node.item;
        }
    }

    public static void main(String[] args) {
        QueueByLink<String> queue = new QueueByLink<>();
        queue.enqueue("A");
        System.out.println(queue.toString());
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");
        queue.enqueue("E");
        System.out.println(queue.toString());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.size());
    }
}
