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
        return items[pq[i]].compareTo(items[qp[j]]) < 0;
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
        exchange(1, N);
        //删除qp中N位置的内容
        qp[pq[N]] = -1;
        //删除items中最大索引处的元素
        items[i] = null;
        //删除pq中最大索引处的内容
        pq[N] = -1;
        //最小元素下沉
        sink(1);
        return item;
    }

    public T delete(int i ){
        //第i个元素对应的数组下标
        int idx = qp[i];
        T item = items[idx];
        //交换pq中该元素与队列尾元素
        exchange(idx, N);
        //删除qp中N位置元素
        qp[pq[N]] = -1;
        //删除items中i位置元素
        items[idx] = null;
        //删除pq中N位置元素
        pq[N] = -1;
        //idx元素上浮后下沉
        swim(idx);
        sink(idx);

        return item;
    }
    //修改i位置元素值
    public void change(int i , T t){
        int idx = qp[i];
        items[idx] = t;

        swim(idx);
        sink(idx);
    }

    public void swim(int i ){
        while (i/2 >= 1){
            if(less(i, i/2)){
                exchange(i, i/2);
                i /= 2;
            }else{
                break;
            }
        }

    }

    public void sink(int i){
        while (2*i <= N){
            int min;
            if(2 * i + 1 <=N){
                min = less(2*i, 2* i + 1) ? 2 * i : 2*i+1;
            }else {
                min = 2 * i;
            }
            if(less(i, min)){
                exchange(i, min);
                i = min;
            }else{
                break;
            }
        }
    }
}
