package com.learn.concurrentprogramming.multiprotest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2019/1/4.
 */
public class MultiPro implements Runnable {

    //    public volatile int b = 0;
    public static int a = 0;
    public volatile int b = 10;
    public static AtomicInteger atomicInteger = new AtomicInteger(10);
    public static ThreadLocal<Integer> tl = new ThreadLocal<Integer>();

    public void run() {
        one();
    }

    public void one() {
//        synchronized (this) {
        outer:
        while (true) {
//            for (int i = 0; i < 20; i++) {

            if (getA() >= 3) {
                System.out.println("已经符合终止条件");
                break outer;
            } else {
                System.out.println("-------------" + Thread.currentThread().getName() + " in -----");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                inA();
            }

            System.out.println(getA());
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            inA();
            //static关键字是实例共享变量，线程之间(不同的实例)由于JVM中每个线程都有独立的工作空间，每个工作空间会拷贝一份主内存中的变量到工作空间中。
            //但由于每个线程中的变量副本更新后并不是立即刷新到主内存中，所以这里会导致线程同步问题，即一个线程拿到的变量可能不是最新的变量
            //此时就产生了volatile关键字,用volatile关键字修饰了的变量在线程之间是立即更新便可见(更改变量后会立即刷新到主内存，读取也直接从主内存读取)
        }
        System.out.println("out---------------------" + Thread.currentThread().getName());
//        }
    }

    public synchronized int getA() {
        return a;
    }

    public synchronized int inA() {
        System.out.println(Thread.currentThread().getName() + "执行一次,执行前次数为 " + getA());
        System.out.println();
        int c = a++;
        System.out.println(Thread.currentThread().getName() + "执行一次,执行后次数为 " + getA());
        System.out.println();

        return c;
    }

    public static void main(String[] args) {
        MultiPro multiPro = new MultiPro();
        Thread t1 = new Thread(multiPro);
        Thread t2 = new Thread(multiPro);
        t1.start();
        t2.start();
    }
}
