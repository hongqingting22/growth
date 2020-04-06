package com.lxl.heap;

import java.util.Arrays;

/**
 * 堆排序
 * 1.构造成堆
 *      1.将原数组构造成堆数组(首元素为空)
 *      2.从堆的1/2处开始下沉，到堆顶元素（根据堆的构造特点，大于1/2的节点都是叶子节点，不需要下沉）
 * 2.循环 --堆顶元素与堆尾元素交换，交换后堆顶元素下沉，堆尾元素不参与下沉
 *              交换后，每次堆尾的元素都是最大的，不参与下沉，则在数组中体现为最大元素依次向前落位
 */
public class HeapSort {

    public static void main(String[] args) {
        String[] arr = {"A","E","B","F","C","D","G"};
        HeapSort sort = new HeapSort();
        sort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(Comparable[] source){
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        int i = heap.length - 1;
        while (i != 1){
            exchange(heap, 1, i);
            sink(heap, 1, --i);
        }
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    public boolean less(Comparable[] heap, int i , int j){
        return heap[i].compareTo(heap[j]) < 0;
    }

    public void exchange(Comparable[] heap ,int i , int j){
        Comparable comparable = heap[i];
        heap[i] = heap[j];
        heap[j] = comparable;
    }

    public void createHeap(Comparable[] source, Comparable[] heap){
        System.arraycopy(source, 0, heap, 1, source.length);

        for(int i = heap.length / 2;i > 0;i--){
            sink(heap, i, heap.length -1);
        }
    }

    public void sink(Comparable[] heap, int k, int range){
        while (2 * k <= range){
            int max;
            if(2 * k + 1 <= range){
                max = less(heap, 2 * k, 2 * k +1) ? 2 * k + 1 : 2 * k;
            }else{
                max = 2 * k;
            }
            if(less(heap, k, max)){
                exchange(heap, k, max);
                k = max;
            }else {
                break;
            }
        }
    }


}
