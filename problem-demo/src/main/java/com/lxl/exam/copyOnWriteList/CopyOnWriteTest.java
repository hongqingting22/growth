package com.lxl.exam.copyOnWriteList;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  CopyOnWriteArrayList
 *  1.add，remove方法使用ReentrantLock加锁
 *  2.copy出数组，放入值后在放回来
 */
public class CopyOnWriteTest {

    public static void main(String[] args) {
        test();

    }
    /**
     * 测试添加删除
     */
    public static void test(){
        CopyOnWriteArrayList<Integer> list = new  CopyOnWriteArrayList();
        list.add(1);
        list.add(0,1);
        System.out.println(list);
        list.add(0,5);
        System.out.println(list);
        list.remove(Integer.valueOf(5));
        list.remove(1);
        System.out.println(list);

    }
}
