package com.kata.jjd.wait_notify;

import sun.jvm.hotspot.debugger.Page;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/4/25
 * @time: 21:49
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/4/25 21:49
 */
public class WaitNofityTest2 {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public WaitNofityTest2() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    static class Resource {
        private static final int MAX_RESOURCE = 10;
        private int resource = 0;

        public int createResource() throws InterruptedException {
            if (resource >= MAX_RESOURCE) {
                wait();
            }
            if(resource < MAX_RESOURCE) {
                this.resource++;
                System.out.println("[" + Thread.currentThread().getName() + "]" + "++产品 : " + this.resource);
                notify();
            }
            return resource;
        }

        public int getResource() throws InterruptedException {

            if (this.resource == 0) {
                wait();
            }
            if(this.resource > 0) {
                this.resource--;
                System.out.println("[" + Thread.currentThread().getName() + "]" + "--产品 : " + this.resource);
                notify();
            }
            return resource;
        }
    }

    static class Productor implements Runnable {

        private final Resource resource;

        Productor(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this.resource) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "Productor 进入");
                        resource.createResource();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {

        private final Resource resource;

        Consumer(Resource resource) {
            this.resource = resource;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this.resource) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getName() + "Consumer 进入");
                        resource.getResource();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        Consumer consumer = new Consumer(resource);
        Productor producter = new Productor(resource);

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

}
