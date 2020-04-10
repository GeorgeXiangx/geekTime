package com.learn.test.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XJH on 2020/3/26.
 *
 * @Description: ? 和 T 的区别:
 *
 * 1.类型通配符?使用场景：使用泛型类型或者泛型方法
 * 2.泛型类型<T>使用场景：用于声明一个泛型类或者泛型方法
 *
 * https://www.cnblogs.com/powerwu/articles/11731959.html
 */
public class DiffBetweenGenericAndWildcard<T> {

    private List<T> item;

    public List<T> get() {
        return item;
    }

    public void set(List<T> t) {
        item = t;
    }

    // 把item取出来再放回去
    public void getSet(DiffBetweenGenericAndWildcard<?> dbgw) {
        // 通配符dbgw<?>.set()的参数类型被编译器捕获，命名为CAP#1，和dbgw<?>.get()返回的 Object对象 无法匹配。
//                dbgw.set(dbgw.get());
        helper(dbgw);
    }

    // ********************************************
    // 解决方法：需要给getSet()方法写一个辅助函数(泛型方法)
    // 具体原理可以去查《Java核心技术-卷1》，泛型这章，或者《Java编程思想》
    private <V> void helper(DiffBetweenGenericAndWildcard<V> dbgw) {
        dbgw.set(dbgw.get());
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        DiffBetweenGenericAndWildcard<String> stringDiffBetweenGenericAndWildcard = new DiffBetweenGenericAndWildcard<>();
        stringDiffBetweenGenericAndWildcard.set(list);
        stringDiffBetweenGenericAndWildcard.getSet(stringDiffBetweenGenericAndWildcard);


        // You can't add an Integer because foo3 could be pointing at a List<Double>.
        // You can't add a Double because foo3 could be pointing at a List<Integer>.
        // You can't add a Number because foo3 could be pointing at a List<Integer>.
        List<? extends Number> foo1 = new ArrayList<Number>();  // Number "extends" Number
        List<? extends Number> foo2 = new ArrayList<Integer>(); // Integer extends Number
        List<? extends Number> foo3 = new ArrayList<Double>();  // Double extends Number

//        foo1.add(1);

        // public static <T> void copy(List<? super T> dest, List<? extends T> src)
        // Collections.copy();
    }
}

