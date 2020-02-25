package com.learn.test.int_and_integer;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * Created by XJH on 2020/2/20.
 *
 * @Description:
 */
public class Counter {
    // 利用原子类在多线程下的安全的计数器
    private final AtomicLong counter = new AtomicLong();

    public void increase(){
        counter.getAndIncrement();
    }
}

class CompactCounter{
    // 利用原始类型,必须以volatile关键字修饰保证可见性
    private volatile long counter;
    private static final AtomicLongFieldUpdater<CompactCounter> updater =
            AtomicLongFieldUpdater.newUpdater(CompactCounter.class, "counter");
    public void increase(){
        updater.incrementAndGet(this);
    }
}
