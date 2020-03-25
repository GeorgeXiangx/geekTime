package com.learn.test.annotation.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:简单的测试框架
 * main方法运行后会自动去检测所有加了@Check注解的方法，并判断方法是否有异常，然后记录到文件中
 *
 * 1.以后大多数时候，使用注解而不是自定义注解
 * 2.注解给谁用？
 *      编译器
 *      解析程序(TestCheck,如果没有解析程序那么注解变的毫无意义)
 * 3.注解不是程序的一部分，注解是一个标签
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        // 1.创建需要检测的类的对象：Calculator
        Calculator calculator = new Calculator();
        // 2.获取字节码文件对象
        Class cls = calculator.getClass();
        // 3.获取所有方法
        Method[] methods = cls.getMethods();

        int count = 0;
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        // 4.判断方法上是否有Check注解
        for (Method method : methods) {
            // 5.有就执行没有就不执行
            if (method.isAnnotationPresent(Check.class)) {
                // 6.捕获异常
                try {
                    method.invoke(calculator);
                } catch (Exception e) {
                    // 7.记录异常
                    count++;
                    bw.write(method.getName() + "出现异常");
                    bw.newLine();
                    bw.write("异常的名称：" + e.getCause().getClass().getName());
                    bw.newLine();
                    bw.write("异常的名称：" + e.getCause().getMessage());
                    bw.write("----------------------------");
                    bw.newLine();
                    e.printStackTrace();
                }
            }
        }
        bw.write("本次测试一共出现" + count + "次异常");

        bw.flush();
        bw.close();
    }
}
