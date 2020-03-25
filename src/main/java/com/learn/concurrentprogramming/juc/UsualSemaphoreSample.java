package com.learn.concurrentprogramming.juc;

import java.util.concurrent.Semaphore;

/**
 * Created by XJH on 2020/3/2.
 *
 * @Description:
 */
public class UsualSemaphoreSample {
    public static void main(String[] args) {
        System.out.println("go...");

        // 模拟交通管理员
        Semaphore semaphore = new Semaphore(5);

        // 模拟乘客
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new SemaphoreWorker(semaphore));
            thread.start();
        }
    }
}

class SemaphoreWorker implements Runnable {
    private String name;
    private Semaphore semaphore;

    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            log("is waiting for a permit");
            semaphore.acquire();
            log("acquired a permit");
            log("executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log("released a permit");
            semaphore.release();
        }
    }

    private void log(String msg) {
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + " " + msg);
    }
}
