package com.kata.jjd.sort;

import java.util.Arrays;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * <p>
 * 冒泡排序
 * 数据结构 ---------- 数组
 * 最差时间复杂度 ---- O(n^2)
 * 最优时间复杂度 ---- 如果能在内部循环第一次运行时,使用一个旗标来表示有无需要交换的可能,可以把最优时间复杂度降低到O(n)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 稳定
 * <p>
 * 图例 : https://images2015.cnblogs.com/blog/739525/201603/739525-20160329100034660-1420925220.gif
 * <p>
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/5/14
 * @time: 11:49
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/5/14 11:49
 */
public class BubbleSort {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public BubbleSort() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    public static void swap(int[] array, int current, int target) {
        int temp = array[current];
        array[current] = array[target];
        array[target] = temp;
    }


    /**
     * 每次从底部循环, 最大的放到数组最后
     * 所以随着次数的增加, 每次循环的元素量会减小.
     *
     * @param array
     */
    public static void sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array.length - j - 1; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        sort(array);
        Arrays.stream(array).forEach(v -> System.out.print(v + ";"));
    }


    /**
     * （1）从2开始，2是最小的质数。
     * （2）除了2之外的偶数全都不是质数，因为除了1和自身之外它们还能被2整除。若为大于2的奇数，则进入下一步继续判断。
     * （3）将其开方，若从3到开方向下取整之间的所有奇数都不能将其整除，则说明该数为质数。
     * <p>
     * 至于为什么只用除到其平方根？
     * 因为如果一个数不是素数是合数，那么一定可以由两个自然数相乘得到，其中一个大于或等于它的平方根，一个小于或等于它的平方根。并且成对出现。
     *
     * @return
     */
    public boolean isPrime(int num) {
        if (num == 2) {
            return true;
        }
        if (num < 2 || num % 2 == 0) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;

    }

}
