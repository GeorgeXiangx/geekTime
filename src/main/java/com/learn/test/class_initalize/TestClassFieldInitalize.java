package com.learn.test.class_initalize;

import com.learn.test.Person;

/**
 * Created by XJH on 2019/10/25.
 *
 * @Description:
 */
public class TestClassFieldInitalize {
    public static void main(String[] args) {
        Person person = new Person();

        System.out.println(person.getName() == null ? "1" : "2");
        System.out.println(person.getAge());
    }
}
