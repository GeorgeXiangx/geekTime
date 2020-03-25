package com.learn.test.generic.method;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:泛型方法
 *
 * 1.修饰符和返回值中间的<T>非常重要，可以理解为声明此方法为泛型方法
 * 2.只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法
 * 3.<T>表名该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T(返回值、参数)
 * 4.此处T可以为任意标识
 * 5.普通的带泛型的成员方法不能被声明为static的
 * 6.泛型方法可以声明为可变参数的
 *
 * 总结：
 * 1.泛型方法能使方法独立于类而产生变化(实际开发中能用泛型方法解决的尽量不要去定义泛型类)
 * 2.如果static方法要使用泛型那么必须使其成为一个泛型方法
 */

public class GenericMethod<T> {

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
    // *** 普通泛型的成员方法不能被声明为static ***
    public T getProduct() {
        return list.get(random.nextInt(list.size()));
    }

    // 泛型方法
    public <E> E getProductE(ArrayList<E> list) {
        return list.get(random.nextInt(list.size()));
    }

    // 泛型方法
    public <T> T getProduct(ArrayList<T> list) {
        return list.get(random.nextInt(list.size()));
    }

    // 静态的泛型方法,采用多个泛型类型
    public static <T, E, K> void printType(T t, E e, K k) {
        System.out.println(t + "\t" + t.getClass().getSimpleName());
        System.out.println(e + "\t" + e.getClass().getSimpleName());
        System.out.println(k + "\t" + k.getClass().getSimpleName());
    }

    // 带可变参数的静态泛型方法
    public static <E> void print(E... e) {
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i]);
        }
    }

    public static void main(String[] args) {
        GenericMethod<Integer> genericMethod = new GenericMethod<>();

        ArrayList<String> list = new ArrayList<>();
        list.add("苹果手机");
        list.add("联想电脑");
        list.add("扫地机器人");

        // 泛型方法的类型是在调用方法的时候指定的
        String product = genericMethod.getProductE(list);
        System.out.println(product + " " + product.getClass().getSimpleName());

        // 即使在泛型方法中定义的泛型标识和类中的标识一样(都是T)，但他们实际上是相互独立的互补影响
        String product2 = genericMethod.getProduct(list);
        System.out.println(product2 + " " + product2.getClass().getSimpleName());

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(100);
        intList.add(3000);
        intList.add(20000);

        Integer product3 = genericMethod.getProduct(intList);
        System.out.println(product3 + " " + product3.getClass().getSimpleName());

        System.out.println("------------------------");
        // 调用时再指定相应的参数泛型类型
        printType("a", 100, false);

        // 可变参数对泛型方法的支持
        System.out.println("------------------------");
        print(1, 2, 3, 4, 5);
        System.out.println("------------------------");
        print("a", "b", "c");
    }
}
