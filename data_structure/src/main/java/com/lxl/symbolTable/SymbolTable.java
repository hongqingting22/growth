package com.lxl.symbolTable;

import java.util.Iterator;

public class SymbolTable<K,V> implements Iterable<K> {
    private Node head;
    private int N;


    class Node{
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SymbolTable() {
        this.head = new Node(null,null,null);
        this.N = 0;
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public boolean containsKey(K key){
        if(isEmpty())return false;
        Node node = head;
        while (node.next != null){
            if(node.next.key.equals(key)){
                return true;
            }else {
                node = node.next;
            }
        }
        return false;
    }

    public void put(K key, V value){
        if(containsKey(key)){
            Node node = head;
            while (node.next != null){
                node = node.next;
                if(node.key.equals(key)){
                    node.value = value;
                    break;
                }
            }
        }else{
            Node next = head.next;
            Node node = new Node(key, value, next);
            head.next = node;
            N++;
        }
    }

    public void remove(K key){
        Node node = head;
        while (node.next != null){
            if(node.next.key.equals(key)){
                node.next = node.next.next;
                N--;
                break;
            }else{
                node = node.next;
            }
        }
    }

    public V get(K key){
        Node node = head;
        while (node.next != null){
            node = node.next;
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("SymbolTable:{items:[");
        for(K key : this){
            sb.append("{").append(key).append(":").append(get(key)).append("},");
        }
        sb.append("],size:").append(N).append("}");
        return sb.toString();
    }

    @Override
    public Iterator<K> iterator() {
        return new MapIterator();
    }

    private class MapIterator implements Iterator{
        private Node node;

        public MapIterator() {
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
            node = node.next;
            return node.key;
        }
    }

    public static void main(String[] args) {
        SymbolTable<String,String> map = new SymbolTable<>();
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        System.out.println(map.toString());

        map.remove("B");
        System.out.println(map.toString());
    }
}
