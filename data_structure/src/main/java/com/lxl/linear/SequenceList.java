package com.lxl.linear;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 内存地址连续，查询快，插入删除慢
 * get O(1)
 * insert O(n)  需要移动元素
 * remove O(n)
 * @param <T>
 */
public class SequenceList<T> implements Iterable<T>{
    private T[] elements;
    private int N;

    public SequenceList(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.N = 0;
    }

    public void clear(){
        this.elements = null;
        this.N = 0;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int length(){
        return N;
    }

    public T get(int i){
        return elements[i];
    }

    public void insert(T t){
        resize();
        elements[N++] = t;
    }

    public void resize(){
        if(N >= elements.length){
            T[] ts = Arrays.copyOf(elements, N+1);
            elements = ts;
        }
    }


    public void insert(int i, T t){
        resize();
        for(int idx = N - 1;idx>=i;idx--){
            elements[idx+1] = elements[idx];
        }
        elements[i] = t;
        N++;
    }

    public T remove(int i){
        T t = get(i);
        for(int idx = i;idx <= N-1;idx++){
            if(idx + 1 <= elements.length - 1){
                elements[idx] = elements[idx+1];
            }else{
                elements[idx] = null;
            }
        }
        N--;
        return t;
    }

    public int indexOf(T t){
        for(int i = 0;i< N;i++){
            if(elements[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "SequenceList{" +
                "elements=" + Arrays.toString(elements) +
                ", N=" + N +
                ", len=" + elements.length +
                '}';
    }

    public static void main(String[] args) {
        SequenceList<String> list = new SequenceList(8);
        list.insert("姚明");
        System.out.println(list);
        list.insert(0, "科比");
        list.insert(1, "麦迪");
        list.insert(0, "C罗");
        list.insert(1, "梅西");
        list.insert(0, "伊布");
        list.insert(1, "卡卡");
        list.insert(0, "大罗");
        System.out.println(list);
        list.insert(1, "小罗");
        System.out.println(list);

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

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }
    private class SIterator implements Iterator{
        private int curse;

        public SIterator() {
            this.curse = 0;
        }

        @Override
        public boolean hasNext() {
            return curse < N;
        }

        @Override
        public Object next() {
            return elements[curse++];
        }

        @Override
        public void remove() {

        }
    }
}
