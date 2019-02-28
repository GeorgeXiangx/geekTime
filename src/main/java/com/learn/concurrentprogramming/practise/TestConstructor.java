package com.learn.concurrentprogramming.practise;

/**
 * Created by XJH on 2019/1/31.
 *
 * @Description:
 */
public class TestConstructor {
    public TestConstructor() {
        System.out.println("TestConstructor");
    }

    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Son extends TestConstructor {
    public Son() {
        this(10);
        System.out.println("Son");
    }

    public Son(int i) {
        System.out.println("Son " + i);
    }
}
