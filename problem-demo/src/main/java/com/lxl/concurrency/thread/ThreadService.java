package com.lxl.concurrency.thread;

/**
 * 优雅的停止线程
 *
 * 执行线程中创建守护线程
 * 使用守护线程执行任务
 *
 */
public class ThreadService {

    private Thread executeThread;

    private boolean finished = false;

    public void execute(Runnable task){
        executeThread = new Thread(){
            @Override
            public void run(){
                Thread runner = new Thread(task);
                runner.setDaemon(true);
                runner.start();

                try {
                    runner.join();//executeThread线程等待守护线程执行
                    finished = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executeThread.start();
    }

    public void shutDown(long mills){
        long current = System.currentTimeMillis();
        while (!finished){
            if(System.currentTimeMillis() - current > mills){
                System.out.println("任务超时，结束线程");
                executeThread.interrupt();
                break;
            }
            try {
                executeThread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("执行线程被打断");
                break;
            }
        }
        finished = false;
    }



}
