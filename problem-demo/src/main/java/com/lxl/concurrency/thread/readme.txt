wait 和 sleep的区别：
1.sleep 是thread的方法，wait是Object的方法
2.sleep不会释放锁，wait会释放锁，并且把线程加入到排队队列中；
3.wait需要和synchronized一起使用
4.wait需要被唤醒