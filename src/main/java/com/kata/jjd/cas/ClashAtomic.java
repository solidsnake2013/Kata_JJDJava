package com.kata.jjd.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * 这个类用来测试冲突的atomic,
 * 用来展示 atomic 在做 CAS 冲突时如何处理
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/5/8
 * @time: 10:06
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/5/8 10:06
 */
public class ClashAtomic {
    /******* Fields Area *******/
    private static AtomicInteger integer = new AtomicInteger(1);

    /******* Construction Area *******/
    public ClashAtomic() {
    }
    /******* GetSet Area ******/



    /******* Method Area *******/

//    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                boolean b = integer.compareAndSet(1, 2);
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                boolean b = integer.compareAndSet(1, 3);
//            }
//        }).start();
//
//        System.out.println(integer.intValue());
//    }


    public static void main(String[] args) {
        int a = 16;
        int b = 5;
        a = b - a; // 2
        System.out.println(a);
        b = b - a; // 3 == a
        a = b + a; // 3 + 2 = 5 = b;

        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }


}
