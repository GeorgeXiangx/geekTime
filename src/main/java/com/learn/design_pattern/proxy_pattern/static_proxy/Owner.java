package com.learn.design_pattern.proxy_pattern.static_proxy;

/**
 * Created by XJH on 2019/12/20.
 *
 * @Description:委托类
 */
public class Owner implements Sales {
    @Override
    public void sell() {
        System.out.println("我是房东(委托类Owner),我正在出售我的房产");
    }
}
