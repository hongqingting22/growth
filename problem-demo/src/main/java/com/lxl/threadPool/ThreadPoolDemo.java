package com.lxl.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) throws Exception{
//        Executors.newFixedThreadPool(3);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

        for(int i = 0;i<100;i++){
            final int finalI = i;
//            Thread.sleep(100);
            threadPoolExecutor.submit(new Thread(()->{
                try {
                    Thread.sleep(1000);
                    System.out.println(finalI + ",thread:" + Thread.currentThread()  + ",线程池：" + threadPoolExecutor.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }));

        }

    }

}
