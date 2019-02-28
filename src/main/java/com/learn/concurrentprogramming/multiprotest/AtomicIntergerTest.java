package com.learn.concurrentprogramming.multiprotest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2019/1/8.
 */
public class AtomicIntergerTest {
    public static AtomicInteger ai = new AtomicInteger(0);

    public synchronized static void test() {
        ai.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " before sleep " + ai.get());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " after sleep " + ai.get());
        System.out.println();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                public void run() {
                    synchronized (this) {
                        while (ai.get() < 5) {
//                        test();
                            System.out.println(Thread.currentThread().getName() + " before increment " + ai.get());
                            ai.incrementAndGet();
                            System.out.println(Thread.currentThread().getName() + " before sleep " + ai.get());
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println(Thread.currentThread().getName() + " after sleep " + ai.get());
                            System.out.println();
                        }
                    }
                }
            }).start();
        }
    }
}
