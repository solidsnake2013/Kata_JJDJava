package com.kata.jjd.sort;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Kata_JJDJava
 * 堆排序
 *
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/5/15
 * @time: 19:59
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/5/15 19:59
 */
public class HeadSort {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public HeadSort() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/



    public static class DefaultCustomFunction implements Consumer<Integer> {

        @Override
        public void accept(Integer a) {
            System.out.println(a);
        }
    }

    public static void ForEachService(int[] a, Consumer<Integer> function) {
        for (int i = 0; i < a.length; i++) {
            function.accept(a[i]);
        }

    }

    public static void sum(int[] a, Consumer<Integer> function) {
        for (int i = 0; i < a.length; i++) {
            function.accept(a[i]);
        }

    }


    public static void main(String[] args) {
        int[] a = { 51, 46, 20, 18, 65, 97, 82, 30, 77, 50 };
        ForEachService(a, new DefaultCustomFunction());
    }





}
