package com.lxl.priorityQueue;

public class MinPriorityQueue<T extends Comparable> {

    private T[] items;
    private int N;

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }
}
