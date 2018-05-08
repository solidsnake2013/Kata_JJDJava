package com.kata.jjd.struct.stack;

import java.util.Stack;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * 倒排表达式栈
 * <p>
 * <p>
 * Creator :
 * Sudao @ Tim Zhang
 * Email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * Date: 2017/7/10
 * Time: 上午11:16
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2017/7/10 上午11:16
 */
public class InvertedOperatorStack {
    /******* Fields Area *******/

    private Stack<String> stack = new Stack<>();


    /******* Construction Area *******/
    public InvertedOperatorStack() {
    }
    /******* GetSet Area ******/


    /******* Method Area *******/


    public InvertedOperatorStack parseCalculateItem(String input) {
        String inputStr = input.replace(" ", "");
        for (int i = 0; i < input.length(); i++) {
            this.stack.push(inputStr.substring(i, i + 1));
        }
        return this;
    }


    public Integer calculate() {
        String pop = this.stack.pop();
        switch (pop) {
            case "+":
                return this.plus(calculate(), calculate());
            case "-":
                return this.remove(calculate(), calculate());
            case "*":
                return this.multiply(calculate(), calculate());
            case "/":
                return this.except(calculate(), calculate());
            default:
                return Integer.parseInt(pop);
        }
    }


    public Integer plus(int a, int b) {
        return a + b;
    }

    public Integer remove(int a, int b) {
        return b - a;
    }

    public Integer multiply(int a, int b) {
        return a * b;
    }

    public Integer except(int a, int b) {
        return b / a;
    }


    public static void main(String[] args) {
        String input = "15+3+4+6+9+9+2/";

        InvertedOperatorStack invertedOperatorStack = new InvertedOperatorStack().parseCalculateItem(input);
        Integer calculate = invertedOperatorStack.calculate();
        System.out.println(calculate);
    }


}
