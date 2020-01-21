package com.learn.concurrentprogramming.multiprotest;

/**
 * Created by XJH on 2019/9/17.
 *
 * @Description:
 */
public class TestInterrput {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (!Thread.currentThread().isInterrupted()) {
                    ++count;
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().isInterrupted());
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " @ " + count);
            }
        });
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();
        Thread.sleep(1000);
        System.out.println("end");
    }
}
