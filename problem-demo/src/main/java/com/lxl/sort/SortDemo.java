package com.lxl.sort;

import org.junit.Test;

/**
 * 排序算法
 */
public class SortDemo {
    /**
     * 冒泡排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        if(null != arr){
            int length = arr.length;
            for(int i = 0;i < length;i++){
                for(int j = 0;j < length - i - 1;j++){
                    if(arr[j] > arr[j+1]){
                        arr[j] ^= arr[j+1];
                        arr[j+1] ^= arr[j];
                        arr[j] ^= arr[j+1];
                    }
                }
            }
        }
    }

    /**
     * 选择排序
     * @param arr
     */
    public static void selectionSort(int[] arr){
        if(null != arr){
            int length = arr.length;
            for(int i = 0;i<length-1;i++){
                int minIndex = i;
                for(int j = i + 1;j<length;j++){
                    if(arr[j] < arr[minIndex]){
                        minIndex = j;
                    }
                }
                if(minIndex != i){//数组元素交换时，使用^,i和minIndex一致时，会导致改下标元素置零
                    arr[i] ^= arr[minIndex];
                    arr[minIndex] ^= arr[i];
                    arr[i] ^= arr[minIndex];
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void insertionSort(int[] arr){
        if(null != arr){
            int length = arr.length;
            int preIndex,current;
            for(int i = 1;i<length;i++){
                preIndex = i - 1;
                current = arr[i];
                while (preIndex >= 0 && arr[preIndex] > current){
                    arr[preIndex + 1] = arr[preIndex];
                    preIndex--;
                }
                arr[preIndex + 1] = current;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,5,4};
//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);
        int length = arr.length;
        for(int i = 0;i < length;i++){
            System.out.println(arr[i]);
        }
    }

    @Test
    public void test(){
        int i = 2;
        int j = 2;
        i ^= j;
        j ^= i;
        i ^= j;
        System.out.println(i + "+" + j);

    }

}
