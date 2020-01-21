package com.learn.test.interrput_test;

/**
 * Created by XJH on 2019/10/31.
 *
 * @Description:
 */
public class InterruptTest {
    public static void main(String[] args) {

        //        ThreadLocal
//        CopyOnWriteArrayList
//        Thread.sleep();
//        Collections.synchronizedList();
//        new ThreadPoolExecutor();
//        Executors.newFixedThreadPool(2);
//        Thread.currentThread().join();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " i ");
                    try {
                        System.out.println("sleep1被中断 " + Thread.currentThread().isInterrupted());
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("sleep22222被中断 " + Thread.currentThread().isInterrupted());
                        System.out.println("被中断 " + Thread.interrupted());
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        t.start();
        t.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        System.out.println(t.interrupted());


//        System.out.println(t.interrupted());
//        System.out.println(t.interrupted());

    }
}
