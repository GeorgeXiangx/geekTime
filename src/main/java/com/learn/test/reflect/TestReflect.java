package com.learn.test.reflect;

import java.lang.reflect.Field;

/**
 * Created by XJH on 2020/2/19.
 *
 * @Description:
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.learn.test.reflect.AccessibleTest");

//        Object o = clazz.newInstance();

        AccessibleTest accessibleTest = new AccessibleTest();
        accessibleTest.setId(1);
        accessibleTest.setName("AT");

        Class clazz2 = accessibleTest.getClass();

        for (Field field : clazz2.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + " " + field.get(accessibleTest));
        }
    }
}
