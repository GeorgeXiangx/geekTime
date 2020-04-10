package com.learn.test.generic.wildcard.upperlimit;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description:
 */
public class Cat extends Animal {
    public int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
