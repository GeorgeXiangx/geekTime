package com.learn.test.generic;

/**
 * Created by XJH on 2020/3/25.
 *
 * @Description:泛型类定义
 *
 * T：泛型标识--类型形参
 * T 创建对象的时候来指定具体的数据类型
 */
public class GenericClass<T> {

    // T是由外部使用类的时候来指定
    T key;

    public GenericClass(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        StringBuilder bulider = new StringBuilder("GenericClass [");
        bulider.append("key=")
                .append(key);
        bulider.append(']');
        return bulider.toString();
    }

    public static void main(String[] args) {
        // 泛型类在创建对象的时候来指定具体的数据类型
        GenericClass<String> str = new GenericClass<>("java");
        System.out.println(str);

        // 1.泛型类在创建对象时没有指定类型，将按照Object类型来操作
        GenericClass o = new GenericClass("python");
        System.out.println(o);

        // 2.泛型类不支持基本数据类型，只支持类类型
//        GenericClass<int> intClass = new GenericClass<>(100);

        // 3.同一泛型类，根据不同的数据类型创建的对象，本质上同一类型
        System.out.println("--------------------------");
        System.out.println(str.getClass());
        System.out.println(o.getClass());
        System.out.println(str.getClass() == o.getClass());
    }
}
