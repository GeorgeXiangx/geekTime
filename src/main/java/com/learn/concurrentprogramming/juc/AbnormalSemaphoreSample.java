package com.learn.concurrentprogramming.juc;

import java.util.concurrent.Semaphore;

/**
 * Created by XJH on 2020/3/2.
 *
 * @Description:
 */
public class AbnormalSemaphoreSample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);

        for (int i = 0; i < 15; i++) {
            Thread t = new Thread(new MyWorker(semaphore));
            t.start();
        }

        // 和之前的相比，这里是先放5个人进来，再一起释放
        System.out.println("go...");
        // Releases the given number of permits, returning them to the semaphore.
        semaphore.release(5);
        // 等待工作线程来申请(申请一个semaphore，计数器减一)
        System.out.println("Wait for permits off " + semaphore.availablePermits());

        // 直到初始化的五个信号量都被申请
        while (semaphore.availablePermits() != 0) {
            System.out.println("semaphore is not 0, wait for");
            Thread.sleep(100);
        }

        System.out.println("go again...");
        semaphore.release(5);
    }
}

class MyWorker implements Runnable {
    private Semaphore semaphore;

    public MyWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            // 申请一个，信号量减一
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " Executed " + semaphore.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
