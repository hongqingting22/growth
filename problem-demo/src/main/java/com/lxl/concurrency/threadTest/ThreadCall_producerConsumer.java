package com.lxl.concurrency.threadTest;

import java.util.LinkedList;

public class ThreadCall_producerConsumer {
    private static int NUM = 1;
    static class Car{
        String name;

        public Car(String name) {
            this.name = name;
        }
    }

    static class Car4s{
        LinkedList<Car> cars = new LinkedList<>();
    }

    static class Producer implements Runnable{
        Car4s shop = new Car4s();

        public Producer(Car4s shop) {
            this.shop = shop;
        }

        @Override
        public void run() {
            try {
                synchronized (shop){
                    while (true){
                        if(shop.cars.size() < 4){
                            Car car = new Car(NUM + "");
                            shop.cars.add(car);
                            System.out.println("生产了一辆汽车-->" + car.name);
                            NUM++;
                            shop.notifyAll();
                        }else{
                            shop.wait();
                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable{
        Car4s shop = new Car4s();

        public Consumer(Car4s shop) {
            this.shop = shop;
        }

        @Override
        public void run() {
            try {
                synchronized (shop){
                    while (true){
                        if(shop.cars.size() > 0){
                            Car poll = shop.cars.poll();
                            System.out.println("购买了一辆汽车-->" + poll.name);
                            shop.notifyAll();
                        }else {
                            shop.wait();
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Car4s shop = new Car4s();
        new Thread(new Producer(shop)).start();
        new Thread(new Consumer(shop)).start();
    }
}
