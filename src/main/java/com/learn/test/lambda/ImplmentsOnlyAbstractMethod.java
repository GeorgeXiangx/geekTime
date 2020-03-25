package com.learn.test.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by XJH on 2020/3/16.
 *
 * @Description: lambda表达式允许你通过表达式来代替功能接口。
 * lambda表达式就和方法一样,它提供了一个正常的参数列表和一个使用这些参数的主体(body,可以是一个表达式或一个代码块)。
 */
public class ImplmentsOnlyAbstractMethod {
    public static void main(String[] args) {
        RunTask r = new RunTask() {
            @Override
            public void run() {
                System.out.println("老方法实现");
            }
        };
        r.run();

        // lambda方式实现
        // 括号里面就是接口中的那个唯一的方法的参数列表,操作符后面就是我们以前实现接口中的方法中的语句
        RunTask r2 = () -> System.out.println("lambda实现");
        r2.run();

        // lambda方式实现,带参数
        RunTaskWithParam r3 = (param) -> System.out.println(param + "World");
        r3.run("Hello");

        // lambda方式实现,带参数带返回值
        RunTaskWithParamAndReturn r4 = (param) -> "Hello" + param;
        String res = r4.run("Hello");
        System.out.println(res);

        // 实现比较器接口
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(3);
        list.add(8);

        // 可以看得到”->" 操作符前面是接口中的方法的参数列表,后面是实现接口的方法中的表达式。
        Collections.sort(list, (Integer a, Integer b) -> a - b);
        System.out.println(list);
    }
}

interface RunTask {
    void run();
}

interface RunTaskWithParam {
    void run(String str);
}

interface RunTaskWithParamAndReturn {
    String run(String str);

//    Error:(33, 40) java: 不兼容的类型: com.learn.test.lambda.RunTaskWithParamAndReturn 不是函数接口
//    在接口 com.learn.test.lambda.RunTaskWithParamAndReturn 中找到多个非覆盖抽象方法
//    void runTask();
}