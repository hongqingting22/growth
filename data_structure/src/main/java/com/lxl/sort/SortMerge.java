package com.lxl.sort;

import java.util.Arrays;

/**
 * 归并排序 O(nLogn),申请了额外的数组空间
 * 循环将数组分为左右两个子数组，再将子数组排序合并
 */
public class SortMerge {

    public static void main(String[] args) {
        int[] arr = {2,5,3,6,1,7,4,3,0};
        SortMerge merge = new SortMerge();
        merge.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void mergeSort(int[] arr){
        sort(arr, 0, arr.length-1);
    }

    public void sort(int[] arr, int start, int end){
        if (start < end){
            int mid = (start + end)/2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    /**
     * 定义三个指针，left,right分别指向左右子数组的起始索引和k指向辅助数组的起始索引
     * 移动左右子数组指针，将小值放入辅助数组
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    public void merge(int[] arr, int start, int mid, int end){
        int[] temp = new int[arr.length];
        int left = start,k = start,right = mid + 1;
        while (left <=mid && right <= end){
            if(arr[left] < arr[right]){
                temp[k++] = arr[left++];
            }else {
                temp[k++] = arr[right++];
            }
        }
        while (left <= mid){
            temp[k++] = arr[left++];
        }
        while (right <= end){
            temp[k++] = arr[right++];
        }

        for(int i = start;i<=end;i++){
            arr[i] = temp[i];
        }
    }

}
