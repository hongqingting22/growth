1.juc
    java.util.concurrent
    java.util.concurrent.atomic
    java.util.concurrent.locks

Runnable和Callable

2.线程和进程
    进程：一个应用，.exe,程序的集合；
    java默认几个线程：main,GC
    一个进程往往包含多个线程

    java无法开启线程：
        new Thread().start();
        底层由本地方法开启：private native void start0();

    并发与并行：
        并发：单核CPU，模拟出多条线程，快速交替
        并行：多核CPU，多个线程同时执行，线程池

    //获取cpu核数
    Runtime.getRuntime().availableProcessors();

    并发编程的本质：充分利用cpu资源

    线程的生命周期
    NEW 新建
    RUNNABLE  运行
    BLOCKED  阻塞
    WAITING  等待
    TIMED_WAITING 超时等待
    TERMINATED 终止

    wait和sleep
    1.来自不同的类：Object类   Thread类
    2.关于锁的释放：wait会释放锁，sleep不释放锁
    3.使用范围不同：wait必须在同步代码块中，sleep可以在任何地方
    4.释放需要捕获异常：wait不需要捕获异常，sleep必须要捕获异常

3.Lock锁
    Synchronized和Lock
    1.Synchronized是内置关键字，Lock是java类
    2.Synchronized无法判断获取锁的状态，Lock可以判断是否获取到了锁
    3.Synchronized会自动释放锁，Lock必须手动释放
    4.Synchronized线程1获取锁之后，线程2会一直等待；Lock锁不一定会一直等待
    5.Synchronized可重入锁，不可以中断，非公平；Lock可重入，可中断，非公平（可设置）
    6.Synchronized适合锁少量代码同步问题，Lock适合锁大量同步代码

4.八锁状态
    1.synchronized锁方法，锁的是实例对象，
        会阻塞对象中其他加synchronized的方法，不会阻塞没有加synchronized的方法
        如果有两个对象，则由于锁的不是同一个对象，不会相互影响；
    2.synchronized锁静态方法，锁的是类对象
        多个对象的操作，加synchronized的方法也会相互阻塞；
        静态同步方法与普通同步方法之间相互不影响。

5.集合类不安全
    List
    解决方案：
    1)Vector  1.0就出现了  加synchronized
    2)Collections.synchronizedList(arrayList);
    3)CopyOnWriteArrayList  写时复制

    Set
    解决方案：
    1）Collections.synchronizedSet(hashSet);
    2)CopyOnWriteArraySet

    Map
    解决方案：


