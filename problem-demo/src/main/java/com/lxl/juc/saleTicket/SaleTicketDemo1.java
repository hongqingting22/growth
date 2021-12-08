package com.lxl.juc.saleTicket;

/**
 * 线程是一个单独的资源类，没有任何附属操作
 * 1.属性，方法
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
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

class Ticket{
    private int number = 50;

    //买票
    public synchronized void sale(){
        if(number > 0){
            System.out.println(Thread.currentThread().getName() + "卖出了" + number-- + ",剩余：" + number);
        }
    }
}
