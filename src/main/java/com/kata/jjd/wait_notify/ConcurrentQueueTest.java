package com.kata.jjd.wait_notify;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

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
 * @time: 13:22
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/4/25 13:22
 */
public class ConcurrentQueueTest {
    /******* Fields Area *******/
    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(10);

    /******* Construction Area *******/
    public ConcurrentQueueTest() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


    static class Consumer implements Runnable {

        private ArrayBlockingQueue<Integer> queue;

        Consumer(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    queue.take();
                    System.out.println(Thread.currentThread().getName() + " --产品 " + this.queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Producter implements Runnable {

        private ArrayBlockingQueue<Integer> queue;

        Producter(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(200);
                    queue.put(1);
                    System.out.println(Thread.currentThread().getName() + " ++产品 " + this.queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
//        Consumer consumer = new Consumer(queue);
//        Producter producter = new Producter(queue);
//
//        for (int i = 0; i < 10; i++) {
//            Thread thread = new Thread(producter);
//            thread.setPriority(2);
//            thread.start();
//        }
//
//        for (int i = 0; i < 1; i++) {
//            Thread thread = new Thread(consumer);
//            thread.setPriority(1);
//            thread.start();
//        }

        System.out.println(cut(42));
        System.out.println(rowSumOddNumbers(42));
//        System.out.println(getMiddle("world"));
    }

    public static int rowSumOddNumbers(int n) {
        //TODO
        int sum = 0;
        int begin = cut(n) * 2 + 1;
        for(int i = 0; i < n; i ++) {
            sum = sum + begin + i * 2;
        }
        return sum;
    }

    public static Integer cut(int n) {
        int begin = n * ((n - 1) / 2);
        if((n - 1) % 2 == 1) {
            begin = begin + ((n - 1) / 2) + ((n - 1) % 2);
        }
        return begin;
    }
}
