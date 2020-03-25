package com.learn.test.annotation;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:注解测试类
 */

@MetaAnno
@AnnoDesc(1)
public class Person {
    //    @MetaAnno
    int age;
    String name;

    //    @MetaAnno
    public void printName() {

    }
}
