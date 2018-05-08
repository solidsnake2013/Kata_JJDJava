package com.kata.jjd.wait_notify;

import java.io.Serializable;

public class WaitNotifyTest {




    static class Consumer implements Runnable {
        private final Lock lock;
        Consumer(Lock lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            while(true) {

                try {
                    synchronized (lock) {
                        Thread.sleep(100);
                        int product = lock.getProduct();

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Producter implements Runnable {
        private final Lock lock;
        Producter(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    synchronized (lock) {
                        Thread.sleep(20);
                        int product = lock.addProduct();
//                        System.out.println(Thread.currentThread().getName() + " ++产品 " + product);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    static class Lock implements Serializable {
        public final static int PRODUCT_MAX_COUNT = 10;

        private int managerProductCount = 0;


        public int getProduct() throws InterruptedException {
            if(managerProductCount == 0) {
                wait();
            }

            this.managerProductCount = this.managerProductCount - 1;
            System.out.println(Thread.currentThread().getName() + " --产品 " + managerProductCount);
            if(managerProductCount <=  PRODUCT_MAX_COUNT) {
                notify();
            }
            return managerProductCount;
        }

        public  int addProduct() throws InterruptedException {
            if(managerProductCount >=  PRODUCT_MAX_COUNT) {
                wait();
            }else {
                this.managerProductCount = this.managerProductCount + 1;
                System.out.println(Thread.currentThread().getName() + " ++产品 " + managerProductCount);
                notify();
            }
            return this.managerProductCount;
        }

    }

    public static void main(String[] args) {
        Lock lock = new Lock();
        Consumer consumer = new Consumer(lock);
        Producter producter = new Producter(lock);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(producter);
            thread.setPriority(2);
            thread.start();
        }

        for (int i = 0; i < 1; i++) {
            Thread thread = new Thread(consumer);
            thread.setPriority(1);
            thread.start();
        }

    }

    public static long cute(long base, long count) {
        if(count <= 1) {
            return base;
        }
        return base * cute(base, count-1);
    }
}