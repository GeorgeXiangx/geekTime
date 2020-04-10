package com.learn.test.generic.wildcard.upperlimit;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description:
 */
public class MiniCat extends Cat {
    public int level;

    public MiniCat(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    @Override
    public String toString() {
        return "MiniCat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                '}';
    }
}
