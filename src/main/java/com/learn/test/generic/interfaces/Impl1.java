package com.learn.test.generic.interfaces;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:非泛型实现类，和继承类似
 */
public class Impl1 implements GenericInterface<String> {

    @Override
    public String get() {
        return "java";
    }

    public static void main(String[] args) {
        Impl1 impl1 = new Impl1();
        System.out.println(impl1.get());
    }
}
