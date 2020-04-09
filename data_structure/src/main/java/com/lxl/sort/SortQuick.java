package com.lxl.sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 查找临界点
 */
public class SortQuick {

    public static void main(String[] args) {
        int[] arr = {2,5,3,6,1,7,4};
        new SortQuick().sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr){
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int left, int right){
        if (left < right){
            int index = getIndex(arr, left, right);
            sort(arr, left, index);
            sort(arr, index + 1, right);
        }
    }

    public int getIndex(int[] arr,int left, int right){
        int start= left,end = right;
        int temp = arr[left];
        while (start < end){
            while (start < end && temp < arr[end]){
                end--;
            }
            arr[start] = arr[end];
            while (start < end && temp > arr[start]){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

    public void exchange(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
