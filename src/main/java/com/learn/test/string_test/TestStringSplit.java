package com.learn.test.string_test;

/**
 * Created by XJH on 2019/10/23.
 *
 * @Description:
 */
public class TestStringSplit {
    public static void main(String[] args) {
        String test = "";
        String[] split = test.split("");
//        Arrays.stream(split).forEach(System.out::print);
        for (String s : split) {
            System.out.println("@" + s);
        }
    }
}
