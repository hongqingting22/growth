package com.lxl.juc.saleTicket;

import java.util.concurrent.locks.ReentrantLock;

/**
 * lock锁实现并发
 */
public class SaleTicketDemo2 {
    public static void main(String[] args) {

        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            for(int i = 0;i< 50;i++){
                ticket.sale();
            }
        },"A").start();
        new Thread(()->{
            for(int i = 0;i< 50;i++){
                ticket.sale();
            }
        },"B").start();
        new Thread(()->{
            for(int i = 0;i< 50;i++){
                ticket.sale();
            }
        },"C").start();
    }
}

class Ticket2{
    private int number = 50;

    ReentrantLock lock = new ReentrantLock();

    //买票
    public void sale(){
        lock.lock();
        try {
            if(number > 0){
                System.out.println(Thread.currentThread().getName() + "卖出了" + number-- + ",剩余：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
