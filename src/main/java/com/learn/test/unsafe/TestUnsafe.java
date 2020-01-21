package com.learn.test.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by XJH on 2020/1/7.
 *
 * @Description:
 */
public class TestUnsafe {
    public static void main(String[] args) {
        // Unsafe 对象不能直接通过 new Unsafe() 或调用 Unsafe.getUnsafe() 获取
        // 1.getUnsafe 被设计成只能从引导类加载器（bootstrap class loader）加载
//        Unsafe unsafe = Unsafe.getUnsafe();
        // 2.Unsafe 被设计成单例模式，构造方法私有
//        new Unsafe();

        // 只能通过反射使用
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe)f.get(null);
            unsafe.putObject(new TestUnsafe(), 10000L, 222);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
