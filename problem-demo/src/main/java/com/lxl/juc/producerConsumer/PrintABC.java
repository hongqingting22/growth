package com.lxl.juc.producerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 条件
 * 执行业务
 * 唤醒
 */
public class PrintABC {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0;i< 10;i++)print.printA();
        },"a").start();
        new Thread(() -> {
            for (int i = 0;i< 10;i++)print.printB();
        },"b").start();
        new Thread(() -> {
            for (int i = 0;i< 10;i++)print.printC();
        },"c").start();
    }
}

class Print{
    Lock lock = new ReentrantLock();
    Condition aCondition = lock.newCondition();
    Condition bCondition = lock.newCondition();
    Condition cCondition = lock.newCondition();
    int num = 1;

    public void printA(){
        lock.lock();
        try {
            while (num != 1){
                aCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + "->A");
            num=2;
            bCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while (num != 2){
                bCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + "->B");
            num = 3;
            cCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while (num !=3){
                cCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + "->C");
            num = 1;
            aCondition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
