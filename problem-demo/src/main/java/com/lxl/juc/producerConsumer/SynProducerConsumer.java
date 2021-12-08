package com.lxl.juc.producerConsumer;

/**
 * synchronized实现线程间通信
 * while(条件){
 *     wait();
 * }
 * 使用wait要用while，if会造成虚假唤醒
 */
public class SynProducerConsumer {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(()->{
            for (int i = 0;i<10;i++)number.increment();
        },"A").start();
        new Thread(()->{
            for (int i = 0;i<10;i++)number.decrement();
        },"B").start();
        new Thread(()->{
            for (int i = 0;i<10;i++)number.increment();
        },"C").start();
        new Thread(()->{
            for (int i = 0;i<10;i++)number.decrement();
        },"D").start();
    }

}

class Number{
    int num = 0;

    public synchronized void decrement(){
        while (num == 0){//wait使用while
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "-->" + num);
        this.notifyAll();
    }
    public synchronized void increment(){
        while (num != 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "-->" + num);
        this.notifyAll();
    }
}
