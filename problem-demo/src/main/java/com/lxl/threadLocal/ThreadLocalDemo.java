package com.lxl.threadLocal;

/**
 * ThreadLocal:线程本地变量，保证线程使用自己的变量
 *
 *
 * 1.Thread类中包含ThreadLocalMap成员属性
 *      map中存储以ThreadLocal为key的键值对
 * 2.Thread内部的Map是由ThreadLocal维护的，由ThreadLocal负责向map获取和设置线程的变量值。
 *     ThreadLocal.get()  获取当前线程的本地变量值
 *     ThreadLocal.set(T value)  设置当前线程的成员属性，以ThreadLocal为key，value为值
 *     ThreadLocal.remove()   移除本地变量值
 *
 * 3.ThreadLocalMap使用的Entry继承了WeakReference，每次垃圾回收都会被回收
 *      使用ThreadLocal作为key，是因为map中可以为给Thread存多个本地变量，
 *      如果以ThreadId作为key，则无法区分多个value
 */
public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    static class TestTask extends Thread{
        @Override
        public void run() {
            try {
                String name = Thread.currentThread().getName();
                threadLocal.set("name:" + name);
                Thread.sleep(2000);
                System.out.println("name:" + threadLocal.get() + "===thread:" + Thread.currentThread());
                threadLocal.set("name:" + name + "new");
                Thread.sleep(2000);
                System.out.println("name:" + threadLocal.get() + "===thread:" + Thread.currentThread());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        for(int i = 1;i<=3;i++){
            TestTask testTask = new TestTask();
            testTask.setName("线程"+String.valueOf(i));
            testTask.start();
        }
    }
}
