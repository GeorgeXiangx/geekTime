package com.learn.multiprotest;

/**
 * Created by Administrator on 2019/1/8.
 */
public class TestSleep {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                public void run() {
                    synchronized (this) {
                        for (int j = 0; j < 3; j++) {
                            System.out.println(Thread.currentThread().getName() + "  " + j + "\n");
                            try {
                                Thread.sleep(0);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }).start();
        }
    }
}
