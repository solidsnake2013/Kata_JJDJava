package com.kata.jjd.sort;

import java.util.Arrays;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * 鸡尾酒排序 / 定向冒泡排序
 * 数据结构 ---------- 数组
 * 最差时间复杂度 ---- O(n^2)
 * 最优时间复杂度 ---- 如果序列在一开始已经大部分排序过的话,会接近O(n)
 * 平均时间复杂度 ---- O(n^2)
 * 所需辅助空间 ------ O(1)
 * 稳定性 ------------ 稳定
 *
 * 图例 : https://images2015.cnblogs.com/blog/739525/201603/739525-20160328160227004-680964122.gif
 *
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/5/14
 * @time: 15:10
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/5/14 15:10
 */
public class CocktailSort {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public CocktailSort() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


    public static void swap(int[] array, int current, int target) {
        int temp = array[current];
        array[current] = array[target];
        array[target] = temp;
    }


    public static void cocktailSort(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            for (int i = left; i < right; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                }
            }
            left++;
        }
    }


    public static void main(String[] args) {
        int[] array = { 6, 5, 3, 1, 8, 7, 2, 4 };
        cocktailSort(array);
        Arrays.stream(array).forEach(v-> System.out.print(v + ";"));
    }

}
