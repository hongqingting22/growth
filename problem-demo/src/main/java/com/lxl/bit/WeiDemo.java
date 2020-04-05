package com.lxl.bit;

public class WeiDemo {

    /**
     * 交换
     * @param a
     * @param b
     */
    public static void reverse(int a,int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ":" + b);
    }
    public static void main(String[] args) {
        reverse(5,3);

        //任何数字与0异或，不改变该数的值
        System.out.println(0^2);
        //2的幂次方二进制表示只有一个1，与n-1=0；
    }
}
