package com.learn.test.annotation;

import java.lang.annotation.*;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:元注解，用于描述注解的注解。下面是java内置的四个注解
 *
 * @Target：描述注解能够作用的位置
 *      ElementType的取值:
 *          TYPE:可作用于类上
 *          METHOD:可作用于方法上
 *          FIELD：可作用于成员变量上
 *
 * @Retention：描述注解能保留的阶段
 *      RUNTIME：当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
 *      CLASS：当前被描述的注解，会保留到class字节码文件中，但不会被JVM读取到
 *      SOURCE：连字节码文件中都不会存在
 *
 * @Documented：描述注解是否被抽取到doc文档中
 *
 *
 * @Inherited：描述注解是否被子类继承
 *
 */

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})// 表示该注解MetaAnno只能作用于类上
@Retention(RetentionPolicy.RUNTIME)// 自定义的注解一般是RunTime阶段
@Documented
@Inherited
public @interface MetaAnno {
}
