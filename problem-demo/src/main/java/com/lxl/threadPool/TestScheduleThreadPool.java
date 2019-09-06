package com.lxl.threadPool;

import java.util.concurrent.*;

/**
 * scheduleWithFixedDelay  任务执行完之后，需要再等待period时长后再次执行
 * scheduleAtFixedRate   任务执行完成之后，如果已经超过了设置的间隔时长（period），则直接继续执行下次任务；
 *                                          如果未超过设置的时长，则从第一次执行的时间计算，按间隔时长执行下次任务。
 */
public class TestScheduleThreadPool {
    private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);

    public static void addTask(String name){
//        scheduledThreadPool.scheduleWithFixedDelay(new CalTask(name), 1000, 1000, TimeUnit.MILLISECONDS);

        scheduledThreadPool.scheduleAtFixedRate(new CalTask(name), 1000, 2000, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        for(int i = 0;i < 10;i++){
            addTask("小李" + i);
        }
    }



}
class CalTask implements Runnable{

    private String name;

    public CalTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println(name + "+" + Thread.currentThread().getName()+"+" + System.currentTimeMillis()) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
