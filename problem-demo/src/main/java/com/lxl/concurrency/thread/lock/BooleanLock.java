package com.lxl.concurrency.thread.lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 使用synchronized实现锁
 */
public class BooleanLock {

    private List<Thread> waiter;

    private boolean MINOTER;

    private Thread currentThread;//当前线程，避免其他线程释放锁。自己加的锁只能自己释放

    public BooleanLock() {
        this.MINOTER = false;
        this.waiter = new ArrayList<>();
    }

    public synchronized void lock(){
        while (MINOTER){
            waiter.add(Thread.currentThread());
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.MINOTER = true;
        waiter.remove(Thread.currentThread());
        currentThread = Thread.currentThread();
    }

    public synchronized boolean lock(long mills){
        if(mills <= 0 ){
            lock();
            return true;
        }else{
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= mills){
                if(MINOTER){
                    Optional.of("线程" + Thread.currentThread().getName() + "未获取到锁，自旋")
                            .ifPresent(System.out::println);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    this.MINOTER = true;
                    currentThread = Thread.currentThread();
                    return true;
                }
            }
            return false;
        }
    }

    public synchronized void unlock(){
        if(Thread.currentThread().equals(currentThread)){
            this.MINOTER = false;
            Optional.of("线程" + Thread.currentThread().getName()  + "释放锁")
                    .ifPresent(System.out::println);
            this.notifyAll();
        }else{
            Optional.of("线程" + Thread.currentThread().getName() + "释放锁失败")
                .ifPresent(System.out::println);
        }
    }

    public List<Thread> getBlockedThread(){
        return Collections.unmodifiableList(waiter);//返回不能修改的集合
    }

    public int getBlockedSize(){
        return waiter.size();
    }

    public static void main(String[] args) {
        final BooleanLock booleanLock = new BooleanLock();
        Stream.of("T1","T2","T3").forEach(name ->
                new Thread(()->{
                    try {
                        if(booleanLock.lock(500)){
                            Optional.of(Thread.currentThread().getName() + "获取锁")
                                    .ifPresent(System.out::println);
                            Optional.of(Thread.currentThread().getName() + "is working")
                                    .ifPresent(System.out::println);
                            Thread.sleep(1000);

                            //可以添加线程钩子进程，当异常退出时，会执行。
                            //但是kill -9  强制杀掉程序不会执行
                            Runtime.getRuntime().addShutdownHook(new Thread(){
                                //释放资源
                            });
                        }else{
                            Optional.of(Thread.currentThread().getName() + "获取锁超时")
                                    .ifPresent(System.out::println);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        booleanLock.unlock();
                    }
                },name).start());

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        booleanLock.unlock();
    }
}
