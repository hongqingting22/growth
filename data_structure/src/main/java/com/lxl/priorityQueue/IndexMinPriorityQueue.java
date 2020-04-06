package com.lxl.priorityQueue;

public class IndexMinPriorityQueue<T extends Comparable> {
    //存储元素
    private T[] items;
    //元素数量
    private int N;
    //元素对应下标，需要堆有序,最小优先队列，保证items[pq[i]] <= items[pq[2*i]],
    //                                           items[pq[i]] <= items[pq[2*i+ 1]]
    private int[] pq;
    //pq逆序，pq值作为索引，索引作为值
    private int[] qp;

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.N = 0;

        //qp每个元素都为-1
        for(int i = 0;i< qp.length; i++){
            qp[i] = -1;
        }
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public boolean less(int i ,int j){
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    public void exchange(int i , int j){
        //交换i，j，
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;

        qp[pq[i]] = j;
        qp[pq[j]] = i;
    }

    public boolean contains(int i){
        return qp[i] != -1;
    }

    public int minIndex(){
        return pq[1];
    }

    public void insert(int i ,T item){
        if(contains(i))return;

        N++;
        items[N] = item;

        pq[N] = i;

        qp[i] = N;

        //上浮
        swim(N);
    }

    public T delMin(){
        //获取最小元素的索引
        int i = minIndex();
        T item = items[i];
        //交换最小和最大索引的元素
        exchange(i, N);
        //删除pq中N位置的内容

        return item;
    }

    public void swim(int i ){


    }
}
