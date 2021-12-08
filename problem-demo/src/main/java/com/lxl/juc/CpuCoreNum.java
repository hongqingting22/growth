package com.lxl.juc;

public class CpuCoreNum {
    public static void main(String[] args) {
        //获取cpu核数
        //cpu密集型和IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
