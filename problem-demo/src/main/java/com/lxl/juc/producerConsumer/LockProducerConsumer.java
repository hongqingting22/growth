package com.lxl.juc.producerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockProducerConsumer {
    public static void main(String[] args) {
        Number2 number2 = new Number2();
        new Thread(() ->{
            for (int i = 0;i<10;i++) {
                number2.increment();
            }
        },"A").start();
        new Thread(() ->{
            for (int i = 0;i<10;i++) {
                number2.decrement();
            }
        },"B").start();
        new Thread(() ->{
            for (int i = 0;i<10;i++) {
                number2.increment();
            }
        },"C").start();
        new Thread(() ->{
            for (int i = 0;i<10;i++) {
                number2.decrement();
            }
        },"D").start();
    }
}

class Number2{
    int num = 0;
    Lock lock= new ReentrantLock();
    Condition condition = lock.newCondition();

    public void decrement(){
        lock.lock();
        try {
            while (num == 0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num--;
            System.out.println(Thread.currentThread().getName() + "-->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void increment(){
        lock.lock();
        try {
            while (num != 0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num++;
            System.out.println(Thread.currentThread().getName() + "-->" + num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
