package com.lxl.concurrency.thread;

import java.util.stream.Stream;

/**
 * 多线程时，需要使用notifyAll
 * wait方法不能使用if做判断，因为线程唤醒后，不一定满足执行条件，可能会有空执行的情况
 */
public class ProducerConsumerMultiThread {

    private final Object LOCK = new Object();

    private volatile boolean isProduced = false;

    private volatile static int i;

    public void produce(){
        synchronized (LOCK){
            while(isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("p->" + ++i);
            isProduced = true;
            LOCK.notifyAll();
        }

    }


    public void consume(){
        synchronized (LOCK){
            while (!isProduced){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("c->" + i);
            isProduced = false;
            LOCK.notifyAll();
        }
    }


    public static void main(String[] args) {
        ProducerConsumerMultiThread consumer = new ProducerConsumerMultiThread();
        Stream.of("P1","P2").forEach(n ->
                new Thread(() ->{
                    while (true)
                        consumer.produce();
                }).start()
        );

        Stream.of("C1","C2").forEach(n ->
                new Thread(() ->{
                    while (true)
                        consumer.consume();
                }).start()
        );

    }
}
