package com.learn.test.annotation.work;

import java.lang.reflect.Method;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:利用注解来替换从配置文件中读取配置
 */

@Pro(className = "com.learn.test.annotation.work.ForReflect1", methodName = "show")
public class ReflectConfiguration {
    public static void main(String[] args) {
        // 1.解析注解
        // 1.1获取注解对象定义位置的对象(注解可能使用在方法或者成员变量上)
        // 类:Class对象  方法:Method对象  成员:Filed对象
        //        clazz.getMethod().getAnnotation()
        //        clazz.getField().getAnnotation()
        Class<ReflectConfiguration> clazz = ReflectConfiguration.class;
        // 1.2获取注解对象
        // 在内存中生成了一个该注解接口的子类实现对象
        /*
        *  public class ProImpl implements Pro{
        *       public String className(){
        *           return "com.learn.test.annotation.work.ForReflect1";
        *       }
        *
        *       public String methodName(){
        *           return "show";
        *       }
        *  }
        * */
        Pro annotation = clazz.getAnnotation(Pro.class);
        // 1.3调用注解对象中定义的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println(className + " " + methodName);

        try {
            // 加载该类进内存
            Class cls = Class.forName(className);
            // 创建实例对象
            Object o = cls.newInstance();
            // 获取方法对象
            Method method = cls.getMethod(methodName);
            // 执行方法
            method.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
