package com.learn.concurrentprogramming.threadlocal;

/**
 * Created by XJH on 2020/3/3.
 *
 * @Description:
 * https://www.jianshu.com/p/3a74e9a98d0c
 * 在ThreadLocal的get(),set()的时候都会清除线程ThreadLocalMap里所有key为null的value。
 * 而ThreadLocal的remove()方法会先将Entry中对key的弱引用断开，设置为null，然后再清除对应的key为null的value。
 */
public class ThreadLocalDemo {
    private static final ThreadLocal<Integer> TL_INT = ThreadLocal.withInitial(() -> 6);
    private static final ThreadLocal<String> TL_STR = ThreadLocal.withInitial(() -> "Hello World");

    public static void main(String[] args) {

        // 6
        System.out.println(TL_INT.get());
        TL_INT.set(TL_INT.get() + 1);
        // 7
        System.out.println(TL_INT.get());
        TL_INT.remove();
        // 会重新初始化值为6
        System.out.println(TL_INT.get());
    }
}
