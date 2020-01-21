package com.learn.test;

/**
 * Created by XJH on 2019/7/29.
 *
 * @Description:
 */
public class TestConstructorException {
    public TestConstructorException() {
        connect("1");
    }

    public void connect(String flag) throws RuntimeException {
        if (flag.equals("1")) {
            throw new RuntimeException("eeee");
        }
    }

    public int getRes(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("");
        } else {
            return a / b;
        }
    }

    public int middleMethod(int a, int b) {
        return this.getRes(a, b);
    }

    public static void main(String[] args) {
        TestConstructorException t = new TestConstructorException();
        t.getRes(1, 2);
        TCE test = new TCE(t);
    }
}

class TCE {
    protected TestConstructorException tt;

    public TCE(TestConstructorException t) {
        System.out.println("-------------");
        this.tt = t;
    }
}