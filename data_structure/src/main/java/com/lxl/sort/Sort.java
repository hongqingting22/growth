package com.lxl.sort;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {2,5,3,6,1,7,4};
        /*bubbleSort(arr);
        System.out.println(Arrays.toString(arr));*/
        /*selectionSort(arr);
        System.out.println(Arrays.toString(arr));*/
        /*insertionSort(arr);
        System.out.println(Arrays.toString(arr));*/
       /* shellSort(arr);
        System.out.println(Arrays.toString(arr));*/
    }

    /**
     * 冒泡排序 O（n^2）
     * 外层为排序次数
     * 内层为排序元素
     * 每次排序后最后的元素为选择出的最大的元素，不再参加下次的排序
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        int length = arr.length;
        int temp;
        for(int i = 0; i < length - 1;i++){
            for(int j = 0;j< length-1-i;j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序 O(n^2)
     * 外层为当前元素
     * 内层为当前元素之后的元素
     * 当前元素和所有之后元素比较，保证当前元素为最小元素
     * @param arr
     */
    public static void selectionSort(int[] arr){
        int length = arr.length;
        int temp;
        for(int i = 0;i< length - 1; i++){
            for(int j = i + 1;j <= length -1;j++){
                if(arr[i] > arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * 插入排序O(n^2)
     * 外层为未排序元素
     * 内层为已排序元素 + 当前加入的元素
     * 比较加入元素与已排序元素的大小
     * @param arr
     */
    public static void insertionSort(Integer[] arr){
        int length = arr.length;
        int temp;
        for(int i = 1;i< length;i++){
            for(int j = i;j>0;j--){
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else {
                    break;
                }
            }
        }
    }

    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(Integer[] arr){
        //1.根据数组长度确定增长量
        int length = arr.length;
        int h = 1;
        while (h < length/2){
            h = 2 * h +1;
        }
        int temp;
        //2.希尔排序
        while (h >= 1){
            //插入排序
            //2.1找到待插入元素
            for(int i = h;i < length;i++){
                //2.2
                for(int j = i;j >= h; j -= h){
                    if(arr[j] < arr[j - h]){
                        temp = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = temp;
                    }
                }
            }
            h /= 2;
        }
    }

    @Test
    public  void shellSortTest() {
        try {
            File file = new File("testSort.txt");
            //写入数据
            /*PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            for(int i = 100000;i>0;i--){
                writer.println(i);
            }*/
            List<Integer> list = new ArrayList();
            //读取数据
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while ((line = reader.readLine()) != null){
                list.add(Integer.valueOf(line));
            }
            reader.close();

            Integer[] arr = new Integer[list.size()];
            list.toArray(arr);

            long start = System.currentTimeMillis();
            shellSort(arr);//27544
//            insertionSort(arr);//23502
            System.out.println(System.currentTimeMillis() - start);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
