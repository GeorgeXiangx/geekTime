package com.learn.test.generic.wildcard.upperlimit;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description:
 */
public class Animal {

    public String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }
}
