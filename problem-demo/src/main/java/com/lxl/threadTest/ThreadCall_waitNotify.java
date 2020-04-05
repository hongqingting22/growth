package com.lxl.threadTest;

public class ThreadCall_waitNotify {

    public static void main(String[] args) {
        Num num = new Num();
        num.number = 1;
        new Thread(new JiOut(num)).start();
        new Thread(new OuOut(num)).start();
    }

    static class Num{
        public int number;
    }

    static class JiOut implements Runnable {
        private Num num;

        public JiOut(Num num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (true){
                try {
                    synchronized (num){
                        if(num.number > 100)break;
                        if(num.number % 2 != 0){
                            System.out.println("奇数线程-->" + num.number);
                            num.number++;
                            num.notify();
                        }else {
                            num.wait();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class OuOut implements Runnable{
        private Num num;

        public OuOut(Num num) {
            this.num = num;
        }

        @Override
        public void run() {
            try {
                while (true){
                    synchronized (num){
                        if(num.number > 100)break;
                        if(num.number % 2 == 0){
                            System.out.println("偶数线程-->"+num.number);
                            num.number++;
                            num.notify();
                        }else {
                            num.wait();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
