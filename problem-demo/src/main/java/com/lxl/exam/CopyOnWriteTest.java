package com.lxl.exam;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  CopyOnWriteArrayList
 *  1.add，remove方法使用ReentrantLock加锁
 *  2.copy出数组，放入值后在放回来
 */
public class CopyOnWriteTest {

    public static void main(String[] args) {


       List list = new  CopyOnWriteArrayList();

    }
}
