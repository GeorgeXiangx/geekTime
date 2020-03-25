package com.learn.concurrentprogramming.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by XJH on 2020/2/28.
 *
 * @Description:
 */
public class ThreadLocalAndPool {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static int get(){
        return threadLocal.get();
    }

    public static void increment(){
        threadLocal.set(threadLocal.get() + 1);
    }

    public static void remove(){
        threadLocal.remove();
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                2,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>());

        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {

                try {
                    long id = Thread.currentThread().getId();

                    int before = get();
                    increment();
                    int after = get();

                    System.out.println("id : " + id + " before : " + before + " after : " + after);
                } finally {
                    // 因为threadlocal维护是 Map<Thread,T>这个结构，而线程池是对线程进行复用的
                    // 如果没有及时的清理，那么之前对该线程的使用，就会影响到后面的线程了，造成数据不准确。
                    remove();
                }
            });
        }

        executorService.shutdown();
    }
}
