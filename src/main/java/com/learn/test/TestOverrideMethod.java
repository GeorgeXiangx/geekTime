package com.learn.test;

/**
 * Created by XJH on 2019/6/28.
 *
 * @Description:
 */
public class TestOverrideMethod extends Base {
    @Override
    public String getName() {
        return "Hi, " + super.getName();
    }

    public static void main(String[] args) {
        TestOverrideMethod t = new TestOverrideMethod();
        System.out.println(t.getName());

        int res = 1;
        switch (res) {

            case 1:
                System.out.println("111");
                break;
            case 2:
                System.out.println("222");
                break;
            default:
                System.out.println("default");
        }
    }
}

class Base {
    private String name = "leo";

    public String getName() {
        return name;
    }
}
