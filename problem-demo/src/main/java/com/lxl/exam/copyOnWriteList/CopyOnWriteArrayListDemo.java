package com.lxl.exam.copyOnWriteList;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class CopyOnWriteArrayListDemo<T> implements List<T>, Serializable {

    ReentrantLock lock = new ReentrantLock();
    private volatile T[] array;


    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        try {
            lock.lock();
            T[] array = getArray();
            int length = this.array.length;
            T[] newArray = (T[])new Object[length + 1];
            System.arraycopy(array, 0, newArray, 0, length + 1);
            newArray[length] = t;
            this.array = newArray;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            lock.lock();
            T[] array = getArray();
            int len = array.length;
            int index = indexOf(o);
            T[] newArray = (T[])new Object[len - 1];
            System.arraycopy(array, 0, newArray, 0 ,index);
            System.arraycopy(array, index+1, newArray, index, len-index-1);
            this.array = newArray;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this.array = null;
    }

    public T[] getArray(){
        return this.array;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T set(int index, T element) {
        lock.lock();
        try {
            T[] array = getArray();
            int len = array.length;
            T oldValue = array[index];
            T[] newArray = (T[])new Object[len];
            System.arraycopy(array, 0, newArray, 0, len);
            newArray[index] = element;
            this.array = newArray;
            return oldValue;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void add(int index, T element) {
        lock.lock();
        try {
            T[] array = getArray();
            int len = array.length;
            if(index > len || index < 0){
                throw new IndexOutOfBoundsException("Index: "+index+
                        ", Size: "+len);
            }
            if(index == len){
                T[] ts = Arrays.copyOf(array, len + 1);
                ts[index] = element;
                this.array = ts;
            }else{
                T[] newArray = (T[]) new Object[len + 1];
                System.arraycopy(array, 0,newArray, 0 , index);
                System.arraycopy(array, index, newArray, index + 1, len - index - 1);
                newArray[index] = element;
                this.array = newArray;
            }
        }finally {
            lock.unlock();
        }
    }

    @Override
    public T remove(int index) {
        lock.lock();
        try {
            T t = get(index);
            T[] array = getArray();
            int len = array.length;
            int numMoved = len - index - 1;
            if(numMoved == 0){
                T[] ts = Arrays.copyOf(array, len - 1);
                this.array = ts;
            }else{
                T[] newArray = (T[]) new Object[len - 1];
                System.arraycopy(array, 0, newArray, 0, index);
                System.arraycopy(array, index + 1, newArray, index, numMoved);
                this.array = newArray;
            }

            return t;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int indexOf(Object o) {
        if(o == null){
            for(int i = 0;i < size();i++){
                if(array[i] == null)return i;
            }
        }else{
            for(int i = 0;i < size();i++){
                if(array[i].equals(o))return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if(o == null){
            for(int i = size()-1;i >= 0;i--){
                if(array[i] == null)return i;
            }
        }else{
            for(int i = size()-1;i >= 0;i--){
                if(array[i].equals(o))return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
