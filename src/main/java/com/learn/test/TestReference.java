package com.learn.test;

/**
 * Created by XJH on 2019/4/4.
 *
 * @Description:
 */
public class TestReference {
    public static void main(String[] args) {
        String t = "hello";
        testStr(t);
        System.out.println(t);
    }

    public static void testStr(String test){
        test = test + "123";
    }
}
