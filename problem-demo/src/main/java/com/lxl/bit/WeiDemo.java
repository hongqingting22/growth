package com.lxl.bit;

public class WeiDemo {

    public static void reverse(int a,int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ":" + b);
    }
    public static void main(String[] args) {
        reverse(5,3);
    }
}
