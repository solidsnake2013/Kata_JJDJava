package com.kata.jjd.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
 * @date: 2018/6/12
 * @time: 19:59
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/5/15 19:59
 */
public class HeapSort {
    /******* Fields Area *******/

//    private List<Integer> headTargets;

    /******* Construction Area *******/
    public HeapSort() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


    /**
     * 构建大顶堆
     * @param targets
     * @param size
     */
    public void buildMaxTopHeap(List<Integer> targets, int size) {
        for (int i = size / 2 ; i >= 0; i--) {
            Integer noteValue = targets.get(i);
            if(i * 2 + 1 < size) {
                Integer rightNextValue = targets.get(i * 2 + 1);
                if(noteValue < rightNextValue) {
                    noteValue = noteValue ^ rightNextValue;
                    rightNextValue = noteValue ^ rightNextValue;
                    noteValue = noteValue ^ rightNextValue;
                    targets.set(i * 2 + 1, rightNextValue);
                }
            }
            if(i * 2 < size) {
                Integer leftNextValue = targets.get(i * 2);
                if(noteValue < leftNextValue) {
                    noteValue = noteValue ^ leftNextValue;
                    leftNextValue = noteValue ^ leftNextValue;
                    noteValue = noteValue ^ leftNextValue;
                    targets.set(i * 2, leftNextValue);
                }
            }
            targets.set(i, noteValue);
        }
    }

    public void sort(List<Integer> targets) {
        for (int i = targets.size(); i > 0 ; i--) {
            buildMaxTopHeap(targets, i);
            Integer top = targets.get(0);
            Integer tail = targets.get(i - 1);
            top = top ^ tail;
            tail = top ^ tail;
            top = top ^ tail;
            targets.set(i - 1, tail);
            targets.set(0, top);
        }
    }


    public static void main(String[] args) {
        Random r = new Random();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            temp.add(r.nextInt(10000));
        }
//        List<Integer> temp = Arrays.asList(1, 4, 5, 3, 2, 8, 9, 12, 89, 31, 66, 6, 73, 75);
        HeapSort heapSort = new HeapSort();
//        heapSort.buildMaxTopHeap(temp, temp.size());
        heapSort.sort(temp);
        System.out.println(temp);
    }
}
