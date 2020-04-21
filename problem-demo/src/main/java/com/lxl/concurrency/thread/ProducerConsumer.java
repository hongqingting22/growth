package com.lxl.concurrency.thread;

import java.util.stream.Stream;

/**
 * 线程间通信  wait notify  notifyAll
 *
 * notify在多线程时会有问题：
 *      notify时，生产者可能唤醒了同为生产者的线程，则会被挂起
 */
public class ProducerConsumer {

    private final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    private volatile static int i;

    public void produce(){
            synchronized (LOCK){
                if(isProduced){
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("p->" + ++i);
                    isProduced = true;
                    LOCK.notify();
                }
            }

    }


    public void consume(){
            synchronized (LOCK){
                if(isProduced){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("c->" + i);
                    isProduced = false;
                    LOCK.notify();
                }else {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }


    public static void main(String[] args) {
        ProducerConsumer consumer = new ProducerConsumer();
            new Thread(() ->{
                while (true)
                consumer.produce();
            }).start();

            new Thread(() ->{
                while (true)
                consumer.consume();
            }).start();

    }


}
