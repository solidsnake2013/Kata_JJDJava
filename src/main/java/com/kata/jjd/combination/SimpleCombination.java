package com.kata.jjd.combination;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * 排列组合
 * 按照给定的数字组.
 * 拆分出线性的组合条目.
 * 例如 给出 1 2 3. 要求两个一组
 * 则可拆成 1,2; 1,3; 2,3
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/5/5
 * @time: 19:06
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/5/5 19:06
 */
public class SimpleCombination {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public SimpleCombination() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/

    private static Long[] arr = {1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L};

    public static void main(String[] a) {




        List<List<Long>> result = new ArrayList<>();
        calculate(arr, 5, result);
        System.out.println(result.size());
        System.out.println(result);

    }

    public static void demo(Long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                long b = arr[i] * arr[j];
                System.out.println(arr[i] + " x " + arr[j] + " = " + b);

            }
        }
        System.out.println("------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    long b = arr[i] * arr[j] * arr[k];
                    System.out.println(arr[i] + " x " + arr[j] + " x " + arr[k] + " = " + b);
                }
            }
        }
        System.out.println("------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        long b = arr[i] * arr[j] * arr[k] * arr[l];
                        System.out.println(arr[i] + " x " + arr[j] + " x " + arr[k] + " x " + arr[l] + " = " + b);

                    }
                }
            }
        }
        System.out.println("------------------");
    }


    // 1. 获得排列组合的二维数组

    public static void calculate(Long[] arr, Integer div, List<List<Long>> results) {
        calculate(arr, div, new Integer[div], results);
    }

    /**
     * @param arr        元数据
     * @param div        循环层级 (可变), 不可变层级由 indexArray.length 修饰
     * @param results    结果集
     * @param indexArray 索引集 (索引级之所以用数组, 是因为它也代表了一个固定的循环层级).
     */
    public static void calculate(Long[] arr, Integer div, Integer[] indexArray, List<List<Long>> results) {
        if (div == 0) {
            // 最后一层级, 获取当前组合项.
            List<Long> result = Arrays.stream(indexArray).map(v -> arr[v]).collect(Collectors.toList());
            results.add(result);
        } else {
            int beginIndex;
            if (indexArray[indexArray.length - div] == null) {
                // 如果是起始索引
                // Example
                // 第一层级 0 [div = 4, indexArray = 4],
                // 第二层为 1 [div = 3, indexArray = 4],
                // 第三层为 2 [div = 2, indexArray = 4],
                // 第四层为 3 [div = 1, indexArray = 4]
                // ...
                beginIndex = indexArray.length - div;

            } else {
                // 如果是传递索引, 也就是说当下层级索引应该在上层级索引的基础之上增加 1
                // Example
                // 第一层级 i=2 [div = 4, indexArray = 4],
                // 第二层级 j=i + 1 [div = 3, indexArray = 4],
                // 第三层级 k=j + 1 [div = 2, indexArray = 4],
                // 第三层级 l=k + 1 [div = 1, indexArray = 4]
                // ...

                // indexArray 根据下表可以获取到对应的层级index
                // 由于进入这个判断, 一定是已经初始化过indexArray的各个层级 (也就是说经过了起始索引阶段, 或又称之为, 完成了一次深度遍历),
                // 所以不会和上一个判断 (起始索引判断) 冲突.
                // 由于判断时, 我们已经处于下一层及, 所以想要获得上一层及的index 必须给dev + 1, 才能对应到相应的 index.
                beginIndex = indexArray[indexArray.length - (div + 1)] + 1;
            }
            for (int i = beginIndex; i <= arr.length - div; i++) {
                // 存储索引到相应层级
                indexArray[indexArray.length - div] = i;
                // 递归进入下一层及, Hold 索引集.
                calculate(arr, div - 1,indexArray, results);
            }
        }
    }



    // 2. 计算每个维度排列组合的乘积

}
