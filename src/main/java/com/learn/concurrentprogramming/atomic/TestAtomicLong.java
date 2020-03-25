package com.learn.concurrentprogramming.atomic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * Created by XJH on 2020/3/4.
 *
 * @Description:
 */
public class TestAtomicLong {
    private volatile long id;
    private final static AtomicLongFieldUpdater<TestAtomicLong> lock =
            AtomicLongFieldUpdater.newUpdater(TestAtomicLong.class,"id");

    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();
        atomicLong.getAndIncrement();
    }

    private void acquireLock(){
        long id = Thread.currentThread().getId();
        while (!lock.compareAndSet(this, 0L, id)) {
            // do something
        }
    }
}
