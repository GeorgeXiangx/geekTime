package com.learn.test.reflect;

/**
 * Created by XJH on 2020/2/19.
 *
 * @Description:
 */
public class AccessibleTest {
    private int id;
    private String name;
    public int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
