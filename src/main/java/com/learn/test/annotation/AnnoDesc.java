package com.learn.test.annotation;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:自定义注解
 * 注解的本质其实就是一个接口，可根据反编译后看出此接口继承自Annotation接口
 * public interface MyAnno1 extends java.lang.annotation.Annotation {
 *    public abstract int age();
 * }
 *
 * 注解的属性(抽象方法)返回值类型有下列取值：
 * 1.基本类型
 * 2.String类型
 * 3.Enum枚举类型
 * 4.注解类型
 * 5.以上所有类型的数组类型
 *
 * 定义了属性，在使用时需要给属性赋值
 * 1.如果定义属性时，使用default关键字给属性默认初始化值，则使用注解时，可以不用对此属性赋值
 * 2.如果只有一个属性且属性的名字叫value，那么在使用的时候可省略value，直接定义值即可
 * 3.数组赋值时，用{}包裹，如果只有一个值，那么{}可以省略
 *
 * Java自带的三个注解
 * @Override 检查子类的方法是否是重写父类的
 * @Deprecated 表示注解的内容已过时不推荐使用
 * @SuppressWarnings 一般传递参数all,@SuppressWarnings("all")
 */

//@SuppressWarnings("all")
//@Deprecated
public @interface AnnoDesc {

//    int age() default 1;
//    String name();
//    Sex sex();
//    MyAnno2 anno();
//
//    float[] money();

//    Person perosn();

    int value();
}
