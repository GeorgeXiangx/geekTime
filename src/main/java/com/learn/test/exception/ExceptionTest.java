package com.learn.test.exception;

/**
 * Created by XJH on 2020/3/30.
 * @Description:
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
//            int i = 1 / 0;
            div(1, 0);
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
        System.out.println("---------------");
    }

    public static int div(int a, int b) {
        int res = 0;
        try {
            res = a / b;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return res;
    }
}
