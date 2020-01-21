package com.learn.concurrentprogramming.test;

/**
 * Created by XJH on 2020/1/10.
 *
 * @Description:
 */
public class TestConcurrentArray {
    public volatile int[] array = new int[]{1, 2};

    public static void main(String[] args) {
        TestConcurrentArray testConcurrentArray = new TestConcurrentArray();
        for (int i = 0; i < 2; i++) {
            new MyThread(i, testConcurrentArray).start();
        }
    }
}

class MyThread extends Thread {
    TestConcurrentArray tca;
    int index;

    public MyThread(int index, TestConcurrentArray tca) {
        this.index = index;
        this.tca = tca;
    }

    @Override
    public void run() {
        int[] temp = tca.array;
        if (index == 0) {
            System.out.println(Thread.currentThread().getName() + " sleep 3s");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            tca.array = new int[]{6, 7};
            System.out.println(Thread.currentThread().getName() + " modified array");
        }

        System.out.println(Thread.currentThread().getName() + " " + (tca.array == temp) + " " + tca.array[1] + " " + temp[1]);
    }
}