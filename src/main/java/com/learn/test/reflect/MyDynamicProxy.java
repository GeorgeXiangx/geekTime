package com.learn.test.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by XJH on 2020/2/19.
 *
 * @Description:
 */
public class MyDynamicProxy {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);

        // 构造代码实例
        // 通过 Proxy 类，调用其 newProxyInstance 方法，生成一个实现了相应基础接口的<代理类实例>
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), handler);
        proxyHello.sayHello();
    }
}

// 提供一个基础的接口，作为被调用类型和代理类之间的统一入口
interface Hello{
    void sayHello();
}

class HelloImpl implements Hello{

    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}

// 实现InvocationHandler，对代理对象方法的调用，会被分派到其 invoke 方法来真正实现动作
class MyInvocationHandler implements InvocationHandler{
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking sayHello");
        Object result = method.invoke(target, args);
        return result;
    }
}
