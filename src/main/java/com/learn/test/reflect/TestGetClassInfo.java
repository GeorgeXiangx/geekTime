package com.learn.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by XJH on 2020/2/19.
 *
 * @Description:
 */
public class TestGetClassInfo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        Student s1 = new Student(); //类的对象

        Class s2 = Student.class;
        Class studentClass = s1.getClass(); //获取该对象的真实Class类型(真实类型)

        System.out.println(studentClass.getName()); //获取父类的名字
        Class superClass = studentClass.getSuperclass(); //获取父类的对象
        System.out.println(superClass.getName());
        superClass.getInterfaces();
        Field[] fields = studentClass.getDeclaredFields(); //获得所有属性

        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Method[] methods = studentClass.getDeclaredMethods();

        Method m2 = studentClass.getDeclaredMethod("print", null);


        try {
            m2.invoke(new Student(), null);
        } catch (IllegalAccessException | IllegalArgumentException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("------------------");

        for(Field f: studentClass.getDeclaredFields()){
            f.setAccessible(true);
            System.out.println(f.get(s1));
        }
    }
}

class Student{
    public int a;
    public int b;
    private int c;

    public void print(){
        System.out.println("This is for reflect");
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
