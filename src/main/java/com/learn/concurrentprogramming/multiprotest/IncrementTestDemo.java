package com.learn.concurrentprogramming.multiprotest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2019/1/7.
 */
public class IncrementTestDemo {

    public static int count = 0;
    public static Counter counter = new Counter();
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    volatile public static int countVolatile = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread() {
                public void run() {

                    for (int j = 0; j < 1000; j++) {
                        if (counter.getValue() >= 10) break;
                        count++;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        counter.increment();
                        atomicInteger.getAndIncrement();
                        countVolatile++;
                    }
                }
            }.start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("static count: " + count);
        System.out.println("Counter: " + counter.getValue());
        System.out.println("AtomicInteger: " + atomicInteger.intValue());
        System.out.println("countVolatile: " + countVolatile);
    }

}

class Counter {
    private volatile int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized int increment() {
        System.out.println(Thread.currentThread().getName() + " 加前数据为 " + value);
        int res = ++value;
        System.out.println(Thread.currentThread().getName() + " 加后数据为 " + value);
        System.out.println();
        return res;
        //        return ++value;
    }

    public synchronized int decrement() {
        return --value;
    }
}
