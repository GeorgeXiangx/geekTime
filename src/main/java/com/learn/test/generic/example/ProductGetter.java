package com.learn.test.generic.example;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:年会抽奖器
 */
public class ProductGetter<T> {
    // 奖品
    private T product;
    Random random = new Random();
    // 奖池
    ArrayList<T> list = new ArrayList<T>();

    // 将奖品放入奖池
    public void addProduct(T t) {
        list.add(t);
    }

    // 随机抽奖
    public T getProduct() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        ProductGetter<String> stringProductGetter = new ProductGetter<>();
        stringProductGetter.addProduct("苹果手机");
        stringProductGetter.addProduct("华为手机");
        stringProductGetter.addProduct("小米手机");
        String product = stringProductGetter.getProduct();
        System.out.println("恭喜您，抽中" + product);

        System.out.println("-----------------------------");

        ProductGetter<Integer> intProductGetter = new ProductGetter<>();
        intProductGetter.addProduct(10000);
        intProductGetter.addProduct(5000);
        intProductGetter.addProduct(800);
        Integer res = intProductGetter.getProduct();
        System.out.println("恭喜您，抽中" + res + "元现金");
    }
}
