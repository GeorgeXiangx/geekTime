package com.learn.design_pattern.proxy_pattern.static_proxy;

/**
 * Created by XJH on 2019/12/20.
 *
 * @Description:代理类
 */
public class Agents implements Sales {
    private Owner owner;

    @Override
    public void sell() {
        System.out.println("我是中介，正在核实购房者是否具有购房资格");
        getOwner().sell();
        System.out.println("我是中介，正在收提成");
    }

    public Owner getOwner() {
        if (owner == null) {
            owner = new Owner();
        }
        return owner;
    }
}
