package com.learn.test.annotation.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:测试注解类
 */

@Target(ElementType.METHOD)
public @interface Check {
}
