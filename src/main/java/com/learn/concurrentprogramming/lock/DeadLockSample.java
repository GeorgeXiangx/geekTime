package com.learn.concurrentprogramming.lock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by XJH on 2020/3/1.
 *
 * @Description:
 */
public class DeadLockSample extends Thread{
    private String first;
    private String second;

    public DeadLockSample(String name, String first, String second) {
        super(name);
        this.first = first;
        this.second = second;
    }

    @Override
    public void run() {
        synchronized (first) {
            System.out.println(this.getName() + " obtained" + first);
            try {
                Thread.sleep(1000);
                synchronized (second) {
                    System.out.println(this.getName() + " obtained" + second);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // ThreadMXBean
        ThreadMXBean mxBean = ManagementFactory.getThreadMXBean();
        Runnable dlCheck = new Runnable() {
            @Override
            public void run() {
                long[] threadIds = mxBean.findDeadlockedThreads();
                if (threadIds != null) {
                    ThreadInfo[] infos = mxBean.getThreadInfo(threadIds);
                    System.out.println("Detected deadlock threads");
                    for (ThreadInfo info : infos) {
                        System.out.println(info.getThreadName());
                    }
                }
            }
        };

        // 用线程池起一个调度任务，稍等5秒，然后每10秒进行一次死锁扫描
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);

        String first = "lockA";
        String second = "lockB";

        DeadLockSample deadLockSample1 = new DeadLockSample("Thread1", first, second);
        DeadLockSample deadLockSample2= new DeadLockSample("Thread2", second, first);

        deadLockSample1.start();
        deadLockSample2.start();
        deadLockSample1.join();
        deadLockSample2.join();
    }
}
