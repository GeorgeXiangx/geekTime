package com.learn.test.generic.generic_array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description:泛型数组的使用,容易引发安全问题
 * 尽量不要使用泛型数组，尽量使用集合类
 */
public class GenericArrayTest {
    public static void main(String[] args) {
        // 1.可以定义一个带泛型的数组，但不能创建
//        ArrayList<String>[] arrayLists = new ArrayList<String>[5];

        // 2.可以定义一个源生的ArrayList数组不带泛型
        ArrayList[] arrayLists = new ArrayList[6];

        // 3.可以赋值引用
        ArrayList<String>[] stringArrayLists = arrayLists;
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1000);

        // 弊端:一个Integer的ArrayList被赋值给一个带String泛型的数组
        arrayLists[0] = intList;

        // 获取String泛型数组中的第一个元素(实际上是一个Integer类型的数据)  -----> ClassCastException
//        String s = stringArrayLists[0].get(0);

        // *********正确的创建姿势1：使用时不要暴露源生的数组直接创建**********
        // 泛型会在编译时进行擦除，而数组却会一直持有类型。两者在设计上就是背道而驰的
        ArrayList<Integer>[] stringArrayLists2 = new ArrayList[10];
        stringArrayLists2[0] = intList;
        System.out.println(stringArrayLists2[0].get(0));

        // 直接填充会进行泛型的检查
//        stringArrayLists2[0] = intList;

        System.out.println("------------------------");
        Fruit<String> fruit = new Fruit<>(String.class, 3);
        fruit.put(0, "java");
        fruit.put(1, "c#");
        fruit.put(2, "scala");
//        fruit.put(3, "python");

        String s = Arrays.toString(fruit.getAll());
        System.out.println(s);
        System.out.println(fruit.getItem(1));
    }
}

class Fruit<T> {
    // T是什么类型都不知道，如何能实例化对象呢？
//    private T[] ts = new T[3];

    private T[] array;

    // 构造函数
    public Fruit(Class<T> claz, int length) {
        // *********正确的创建姿势2：通过发射进行创建**********
        this.array = (T[]) Array.newInstance(claz, length);
    }

    // 填充数组的方法
    public void put(int index, T item) {
        array[index] = item;
    }

    // 获取指定索引位置的数组元素
    public T getItem(int index) {
        return array[index];
    }

    // 获取数组
    public T[] getAll() {
        return array;
    }
}