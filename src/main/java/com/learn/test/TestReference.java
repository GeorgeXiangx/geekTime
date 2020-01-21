package com.learn.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

/**
 * Created by XJH on 2019/4/4.
 *
 * @Description:
 */
public class TestReference {
    public static void main(String[] args) {
        String t = "hello";
        testStr(t);
        System.out.println(t);
        Long a = null;
        String c = null;
        System.out.println(c);

        final StampedLock s1 = new StampedLock();
        long time = s1.readLock();
        s1.tryConvertToWriteLock(time);

        new ThreadPoolExecutor(1, 3, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10));
    }

    public static void testStr(String test) {
        test = test + "123";
    }
}
