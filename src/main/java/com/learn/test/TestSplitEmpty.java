package com.learn.test;

/**
 * Created by XJH on 2019/10/8.
 *
 * @Description:
 */
public class TestSplitEmpty {
    public static void main(String[] args) {
        String test = "a=";
        int length = test.split("=").length;
        System.out.println(length);
    }
}
