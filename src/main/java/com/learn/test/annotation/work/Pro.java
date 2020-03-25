package com.learn.test.annotation.work;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:描述需要执行的类名和方法名
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {

    String className();

    String methodName();
}

/*
*  public class ProImpl implements Pro{
*       public String classNam(){
*           return "com.learn.test.annotation.work.ForReflect1";
*       }
*
*       public String methodName(){
*           return "show";
*       }
*  }
*
* */

