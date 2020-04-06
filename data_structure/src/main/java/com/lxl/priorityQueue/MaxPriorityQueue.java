package com.lxl.priorityQueue;

public class MaxPriorityQueue<T extends Comparable> {

    private T[] items;
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity];
        this.N = 0;
    }

    public boolean less(int i , int j){
        return items[i].compareTo(items[j]) < 0;
    }

    public void exchange(int i ,int j){
        T item = items[i];
        items[i] = items[j];
        items[j] = item;
    }

    public void push(T item){
        items[++N] = item;
        swim(N);
    }

    public T pop(){
        T item = items[1];
        exchange(1, N--);
        sink(1);
        return item;
    }

    public T peek(){
        return items[1];
    }

    public void swim(int k){
        while (k > 1){
            if(less(k/2, k)){
                exchange(k, k/2);
                k /= 2;
            }else {
                break;
            }
        }
    }

    public void sink(int k){
        while (2 * k <= N){
            int max;
            if(2 * k + 1 <= N){
                max = less(2 * k, 2 * k + 1) ? 2 * k + 1 : 2 * k;
            }else{
                max = 2 * k;
            }
            if(less(k , max)){
                exchange(k, max);
                k = max;
            }else{
                break;
            }
        }
    }

    public int size(){
        return N;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public static void main(String[] args) {
        MaxPriorityQueue<String> queue = new MaxPriorityQueue<String>(16);

        queue.push("A");
        queue.push("B");
        queue.push("C");
        queue.push("D");
        queue.push("E");
        queue.push("F");
        queue.push("G");
        queue.push("H");

        while (!queue.isEmpty()){
            String s = queue.pop();
            System.out.println(s);
        }

    }
}
