package com.learn.test.break_test;

/**
 * Created by XJH on 2019/11/12.
 *
 * @Description:
 */
public class BreakForDoubleLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 3) break;
                System.out.println(i + " " + j);
            }
        }
    }
}
