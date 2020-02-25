package com.learn.concurrentprogramming.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2019/1/7.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        int i = 10;
        System.out.println(i--);
        int j = 0;
        j = ++j;
        System.out.println(j);
        System.out.println(Long.MAX_VALUE);
        System.out.println(Math.pow(2, 256));
//        Predicate
        TimeUnit.SECONDS.sleep(200);

//        ThreadLocal

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put(1, 1);
        System.out.println(concurrentHashMap.size());

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50,
                500,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(200),
                r -> {
                    return new Thread(r, "echo-" + r.hashCode());
                },
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
