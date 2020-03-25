package com.learn.concurrentprogramming.lock;

/**
 * Created by XJH on 2020/2/28.
 *
 * @Description:
 */
public class GetTheThreadCount {
    public static void main(String[] args) {
        System.out.println("Hello World");

        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup parent = threadGroup;

        while (parent != null) {
            threadGroup = parent;
            parent = parent.getParent();
        }

        int count = threadGroup.activeCount();
        Thread[] threads = new Thread[count];
        threadGroup.enumerate(threads);

        for (int i = 0; i < threads.length; i++) {
            System.out.println("线程Num : " + i + " = " + threads[i].getName());
        }
    }
}
