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
 *
 *     内存泄漏问题：
 *     static class Entry extends WeakReference<ThreadLocal<?>>
 *          ThreadLocalMap的key是弱引用，GC时key会被回收，但是value不会被回收，
 *              会造成无用对象一直存在JVM中
 *          详见下图：
 *          ThreadLocal对象 <----------------------\
 *                                                 \
 *          Thread对象<-ThreadLocalMap对象<-Entry<key,value>
 *          ThreadLocal对象可以被回收，但是只是key为null，为null后，键值对已成为无用数据，但是不会被回收
 *          问题：为什么要使用弱引用？
 *              如果为强引用，则即使线程已经结束，对象仍然不会被回收，会造成OOM。
 *          解决内存泄漏问题：
 *              1.ThreadLocal对象自身的解决方案：会在get，set，remove时将所有key为空的键值对擦除；
 *              2.程序解决：线程使用完本地变量之后，就像关闭流一样，调用remove方法，擦除键值对。
 *
 *
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
