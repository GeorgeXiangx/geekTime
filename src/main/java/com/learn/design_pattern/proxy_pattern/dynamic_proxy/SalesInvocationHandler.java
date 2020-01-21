package com.learn.design_pattern.proxy_pattern.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by XJH on 2019/12/20.
 *
 * @Description: SalesInvocationHandler实现了InvocationHandler的invoke方法
 * 当代理对象的方法被调用时，invoke方法会被回调。其中proxy表示实现了公共代理方法的动态代理对象
 */
public class SalesInvocationHandler implements InvocationHandler {
    // 代理类持有一个委托类的对象引用
    private Object delegate;

//    public SalesInvocationHandler(Object delegate) {
//        this.delegate = delegate;
//    }

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                this);
    }

    // 集中处理在动态代理类对象上的方法调用，通常在该方法中实现对委托类的代理访问
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Enter method : " + method.getName());
        long start = System.currentTimeMillis();

        Object result = method.invoke(delegate, args);

        long end = System.currentTimeMillis();

        System.out.println("Exit method " + method.getName());
        System.out.println("执行时间：" + (end - start));

        return result;
    }
}
