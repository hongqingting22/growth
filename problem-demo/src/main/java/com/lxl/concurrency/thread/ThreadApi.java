package com.lxl.concurrency.thread;

import com.sun.jmx.snmp.tasks.ThreadService;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadApi {

    public static final Object MINOTOR = new Object();
    public static void main(String[] args) {
        Thread t = new Thread(() ->{
            for(int i = 1;i< 100;i++){
                System.out.println(Thread.currentThread().getName() + "-index"+i);
            }
        }, "t1");
        t.setPriority(Thread.MIN_PRIORITY);
        Thread t2 = new Thread(() ->{
            for(int i = 1;i< 100;i++){
                System.out.println(Thread.currentThread().getName() + "-index"+i);
            }
        }, "t2");
        t2.setPriority(Thread.MAX_PRIORITY);
        Optional.of(t.getId()).ifPresent(System.out::println);
        Optional.of(t.getName()).ifPresent(System.out::println);

        //优先级
        Optional.of(t.getPriority()).ifPresent(System.out::println);
        Optional.of(t2.getPriority()).ifPresent(System.out::println);
        t.start();
        t2.start();


    }

    /**
     *其他线程等待我执行结束
     */
    @Test
    public void testJoin() {
        try {
            Thread thread = new Thread(() -> {
                IntStream.range(1, 100).forEach(i ->
                        System.out.println(Thread.currentThread().getName() + "->" + i)
                );
            });
            thread.start();

            thread.join();

            IntStream.range(1, 100).forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * main线程等待main线程
     */
    @Test
    public void testJoin2(){
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInterrupted(){
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("收到中断信号");
                    e.printStackTrace();
                }
            }
        });

        t.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }


    @Test
    public void testInterrupted2(){
        Thread t = new Thread(() -> {
            while (true) {
               synchronized (MINOTOR){
                   try {
                       MINOTOR.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        });

        t.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t.isInterrupted());
        t.interrupt();
        System.out.println(t.isInterrupted());
    }

}
