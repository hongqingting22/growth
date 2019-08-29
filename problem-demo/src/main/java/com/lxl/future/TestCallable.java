package com.lxl.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class TestCallable {
    public static void main(String[] args) throws Exception{
        String question = "明天会下雨么？";
        String questoin2 = "去吃饭么？";
        String question3 = "吃饱了么？";
        String[] questions = new String[]{question,questoin2,question3};
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<String> answers = new ArrayList<String>();
        long start = System.currentTimeMillis();
        List<Future<String>> futures = new ArrayList<Future<String>>();
        for(String qu : questions){
            NewTask newTask = new NewTask(qu);
            Future<String> future = executorService.submit(newTask);
            futures.add(future);
        }
        for(Future<String> future : futures){
            String s = future.get();//阻塞
            answers.add(s);
        }

        executorService.shutdown();
        for(String an : answers){
            System.out.println(an);
        }
        long end = System.currentTimeMillis();
        System.out.println(end- start);


    }
}

class NewTask implements Callable<String>{
    String question;
    public NewTask(String question){
        this.question = question;
    }
    public String call() throws Exception {
        question = question.replaceAll("？","").replaceAll("么","")
                .replaceAll("吗","");
        Thread.sleep(2000);
        return question;
    }
}


