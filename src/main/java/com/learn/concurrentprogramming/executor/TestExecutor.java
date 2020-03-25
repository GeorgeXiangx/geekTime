package com.learn.concurrentprogramming.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by XJH on 2020/3/3.
 *
 * @Description:
 */
public class TestExecutor {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor();
//        ThreadPoolExecutor

        new ThreadFactory(){
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t, Throwable e) {
                        System.out.println(t.getName() + e);
                    }
                });
                return null;
            }
        };
    }
}
