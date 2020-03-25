package com.learn.test.generic.wildcard;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:泛型通配符测试类
 *
 * 1.类型通配符一般是使用"?"去代替具体的类型实参
 * 2.所以类型通配符是类型实参，而不是类型形参
 */
public class Test {
    public static void main(String[] args) {
        Box<Number> numberBox = new Box<>();
        numberBox.setFirst(100);
        showBox(numberBox);

        Box<Integer> integerBox = new Box<>();
        integerBox.setFirst(8);
        showBox(integerBox);
    }

//    public static void showBox(Box<Number> box) {
//        System.out.println(box.getFirst());
//    }

    // 这里无法使用方法的重载
    // 重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
    // 每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。
    // 最常用的地方就是"构造器"的重载。
    // *** 因为他们的参数类型都一样(泛型会在编译的时候被erasure擦除) ***
//    public static void showBox(Box<Integer> box) {
//        System.out.println(box.getFirst());
//    }


    // 用泛型通配符"?",代表可传递任意类型
    // 用Object类型去接收
    public static void showBox(Box<?> box) {
        Object first = box.getFirst();
        System.out.println(first);
    }
}
