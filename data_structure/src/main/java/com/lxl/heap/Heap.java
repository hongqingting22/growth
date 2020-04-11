package com.lxl.heap;

import java.util.Arrays;

/**
 *大顶堆
 * 1.数组下标从1开始
 * 2.插入元素
 *      1）插入到数组最后的位置，2）该位置元素上浮
 * 3.删除元素
 *      1）该元素与数组最后元素位置互换，2）删除最后元素，3）该元素下沉
 * @param <T>
 */
public class Heap<T extends Comparable>{

    private T[] items;
    private int n;

    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.n = 0;
    }

    //判断堆中i，j位置元素大小
    public boolean less(int i ,int j){
        return items[i].compareTo(items[j]) < 0;
    }

    //交换i，j元素
    public void exchange(int i, int j){
        T temp = items[j];
        items[j] = items[i];
        items[i] = temp;
    }

    /**
     * 插入数据
     *     1.插入到数组尾部
     *     2.将该位置元素上浮（判断是否比父节点大）
     * @param t
     */
    public void insert(T t){
        if(n + 1 >= items.length){
            resize();
        }
        items[++n] = t;
        swim(n);
    }

    public void resize(){
        T[] newItems = (T[])new Comparable[n*2];
//        for(int i = 1;i<= n;i++){
//            newItems[i] = items[i];
//        }
        System.arraycopy(items, 1, newItems, 1, n);
        items = newItems;
    }
    //上浮操作：保证父节点元素大于子节点元素
    public void swim(int k){
        while (k > 1){
            if(less(k/2, k)){//父节点比当前节点小
                exchange(k/2,k);
                k /= 2;
            }else{
                break;
            }
        }
    }

    /**
     * 删除最大节点
     * 1.交换第一个和最后一个元素
     * 2.删除最后一个元素
     * 3.下沉k节点
     */
    public T delMax(){
        T t = items[1];
        exchange(1, n);
        items[n--] = null;
        sink(1);
        return t;
    }

    /**
     * 下沉节点
     * 循环比较该节点与子节点中较大节点
     * @param k
     */
    public void sink(int k){
        while (2*k <= n){
            int left = 2 *k;
            int right = 2 * k + 1;
            if(2*k + 1 > n){
                right = left;
            }
            int max = less(left, right) ? right : left;
            if(less(k, max)){
                exchange(k, max);
                k = max;
            }else{
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Heap{" +
                "items=" + Arrays.toString(items) +
                ", n=" + n +
                '}';
    }

    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(4+1);
        heap.insert("A");
        System.out.println(heap);
        heap.insert("B");
        System.out.println(heap);
        heap.insert("C");
        System.out.println(heap);
        heap.insert("D");
        System.out.println(heap);
        heap.insert("E");
        System.out.println(heap);
        heap.insert("F");
        System.out.println(heap);
        heap.insert("G");
        System.out.println(heap);
        heap.insert("H");
        System.out.println(heap);

        while (heap.n != 0){
            String s = heap.delMax();
            System.out.println(s);
        }
    }

}


