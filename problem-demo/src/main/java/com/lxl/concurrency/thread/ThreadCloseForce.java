package com.lxl.concurrency.thread;

public class ThreadCloseForce {

    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        threadService.execute(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadService.shutDown(3000);//3秒钟未执行完，结束线程
    }
}
