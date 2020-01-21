package com.learn.design_pattern.proxy_pattern.static_proxy;

/**
 * Created by XJH on 2019/12/20.
 *
 * @Description:客户类
 */
public class Customer {
    public static void main(String[] args) {
        Sales sales = new Agents();
        sales.sell();
    }
}
