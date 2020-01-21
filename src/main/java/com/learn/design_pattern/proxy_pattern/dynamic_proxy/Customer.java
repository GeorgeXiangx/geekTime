package com.learn.design_pattern.proxy_pattern.dynamic_proxy;

import com.learn.design_pattern.proxy_pattern.static_proxy.Owner;
import com.learn.design_pattern.proxy_pattern.static_proxy.Sales;

/**
 * Created by XJH on 2019/12/20.
 *
 * @Description:
 */
public class Customer {
    public static void main(String[] args) {
        // 代码通过InvocationHandler handler=new SalesInvocationHandler(delegate);
        // 将委托对象作为构造方法的参数传递给了SalesInvocationHandler来作为代理方法调用的对象。
        // 当我们调用代理对象的sell()方法时，该调用将会被转发到SalesInvocationHandler对象的invoke上，从而达到动态代理的效果。
        // 从代码可以看出，客户端需要负责自己创建代理对象，显得有点繁琐，其实我们可以将代理对象的创建封装到代理协调器的实现中。
//        Sales delegate = new Owner();
//        InvocationHandler handler = new SalesInvocationHandler(delegate);
//
//        Sales proxy = (Sales) Proxy.newProxyInstance(
//                delegate.getClass().getClassLoader(),
//                delegate.getClass().getInterfaces(),
//                handler);

        Sales delegate = new Owner();
        Sales proxy = (Sales)new SalesInvocationHandler().bind(delegate);
        proxy.sell();
    }
}
