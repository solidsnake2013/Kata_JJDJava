package com.kata.jjd.alibabap7;

/**
 * Kata_JJDJava
 * <p>
 * Description :
 * <p>
 * Creator :
 *
 * @author Sudao @ Tim Zhang
 * @email : zhanglong@kuaicto.com or solidsnake2007@gmail.com
 * @date: 2018/5/15
 * @time: 19:34
 * =========================================
 * <p>
 * Contributors :
 * Tim Zhang - 2018/5/15 19:34
 */
public class Step1 {
    /******* Fields Area *******/

    /******* Construction Area *******/
    public Step1() {
    }
    /******* GetSet Area ******/

    /******* Method Area *******/


//    public static void main(String[] args) {
//
//    }

    public static void main(String[] args) {
        String s1 = "test1", s2 = "test1";
        System.out.print(s1 == s2 ? 1 : 0);
        // 1

        String s3 = new String("test1");
        System.out.print(s1 == s3 ? 1 : 0);
        // 0

        String s4 = s3.intern();
        System.out.print(s3 == s4 ? 1 : 0);
        System.out.print(s1 == s4 ? 1 : 0);
        // 1
        // 1

        String s5 = "test2", s6 = s5.intern();
        System.out.print(s5 == s6 ? 1 : 0);
        // 1


    }


}
