package com.lxl.lock.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {
    private static int m = 0;
    private static ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void method1() throws Exception{
        Thread[] threads = new Thread[100];

        for(int i = 0; i<threads.length;i++){
            threads[i] = new Thread(() ->{
                    for(int j = 0;j< 100;j++)m++;
            });
        }

        for (Thread thread: threads) {
            thread.start();
        }
        for(Thread t : threads)t.join();
        System.out.println(m);
    }



    public static void method2() throws Exception{
        Thread[] threads = new Thread[100];

        for(int i = 0; i<threads.length;i++){
            threads[i] = new Thread(() ->{
                synchronized (Demo1.class){
                    for(int j = 0;j< 100;j++)m++;
                }
            });
        }

        for (Thread thread: threads) {
            thread.start();
        }
        for(Thread t : threads)t.join();
        System.out.println(m);
    }

    public static void method3() throws Exception{
        Thread[] threads = new Thread[100];

        for(int i = 0; i<threads.length;i++){
            threads[i] = new Thread(() ->{
                try {
                    lock.lock();
                    for(int j = 0;j< 100;j++)m++;
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });
        }

        for (Thread thread: threads) {
            thread.start();
        }
        for(Thread t : threads)t.join();
        System.out.println(m);
    }

    public static void main(String[] args) throws Exception{
//        method1();
//        method2();
        method3();
    }
}
