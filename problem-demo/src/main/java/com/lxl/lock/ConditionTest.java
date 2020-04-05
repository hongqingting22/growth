package com.lxl.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印1,2,3
 */
public class ConditionTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            try {
                while (true){
                    lock.lock();
                    Thread.sleep(300);
                    System.out.println("1");
                    conditionA.await();
                    conditionB.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "A");
        Thread b = new Thread(() -> {
            try {
                while (true){
                    lock.lock();
                    Thread.sleep(300);
                    System.out.println("1");
                    conditionB.await();
                    conditionC.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "B");
        Thread c = new Thread(() -> {
            try {
                while (true){
                    lock.lock();
                    Thread.sleep(300);
                    System.out.println("1");
                    conditionC.await();
                    conditionA.signalAll();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "C");
        a.start();
        b.start();
        c.start();

    }


}
