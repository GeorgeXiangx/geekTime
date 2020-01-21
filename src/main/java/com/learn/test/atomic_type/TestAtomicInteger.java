package com.learn.test.atomic_type;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by XJH on 2020/1/9.
 *
 * @Description:
 */
public class TestAtomicInteger {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        int i = atomicInteger.getAndIncrement();
        int i2 = atomicInteger.incrementAndGet();
    }
}
