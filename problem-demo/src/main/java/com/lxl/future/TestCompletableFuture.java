package com.lxl.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class TestCompletableFuture {
    public static void test1(){
        try {
            List<String> list = new CopyOnWriteArrayList<>();
            StringBuilder sb = new StringBuilder();

            ExecutorService executorService = Executors.newFixedThreadPool(10);
            int num = 100;
            long start = System.currentTimeMillis();
            CountDownLatch latch =new CountDownLatch(num);
            for(int i = 1;i<=num;i++){
                final int finalI = i;
/*                CompletableFuture.supplyAsync(()-> {
                    return "result" + finalI + temp;
                },executorService).whenCompleteAsync((result, e) -> {
                    list.add(result);
                    latch.countDown();
                }).exceptionally((e) -> {
                    latch.countDown();
                    return "exception";
                });*/
                CompletableFuture.supplyAsync(new CalTask(finalI),executorService)
                        .whenCompleteAsync((result, e) -> {
                    list.add(result);
                    sb.append(result);
                    latch.countDown();
                }).exceptionally((e) -> {
                    latch.countDown();
                    return "exception";
                });
            }

//            Thread.sleep(3000);
            latch.await();
        executorService.shutdown();
        long end = System.currentTimeMillis();
            System.out.println("count:"+list.size() + ",time:" + (end - start));
        for(String str : list){
            System.out.println(str);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test1();
    }

    static class CalTask implements Supplier<String>{
        Integer i;
        public CalTask(Integer i ){
            this.i = i;
        }

        @Override
        public String get() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i + "--" + i;
        }
    }
}
