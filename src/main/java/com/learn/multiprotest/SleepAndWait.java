package com.learn.multiprotest;

/**
 * Created by Administrator on 2019/1/8.
 */
public class SleepAndWait implements Runnable {
    int number = 10;

    public void addHundred() throws Exception {
        System.out.println("addHundred  begin");
        synchronized (this) {
            System.out.println("----------in-------------");
            number += 100;
            Thread.sleep(500);
            System.out.println("addHundred:" + number);
        }
        System.out.println("addHundred  end");
    }

    public void wait2Seconds() throws Exception {
        System.out.println("wait2Seconds begin ");
        synchronized (this) {
            /**
             * (休息2S,阻塞线程)
             * 以验证当前线程对象的机锁被占用时,
             * 是否被可以访问其他同步代码块
             */
            System.out.println(".............wait begin..................");
            this.wait(2000);
            number *= 200;
            System.out.println(".............wait end..................");
        }
        System.out.println("wait2Seconds end ");
    }

    public void sleep2Seconds() throws Exception {
        System.out.println("sleep2Seconds begin ");
        synchronized (this) {
            /**
             * (休息2S,阻塞线程)
             * 以验证当前线程对象的机锁被占用时,
             * 是否被可以访问其他同步代码块
             */
            System.out.println("............sleep begin...................");
            Thread.sleep(2000);
            number *= 200;
            System.out.println(".............sleep end..................");
        }
        System.out.println("sleep2Seconds end ");
    }

    public void run() {
        try {
            addHundred();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SleepAndWait threadTest = new SleepAndWait();
        Thread thread = new Thread(threadTest);
        Thread thread2 = new Thread(threadTest);
        thread.start();
        thread2.start();
//        threadTest.sleep2Seconds();
        //threadTest.wait2Seconds();
    }
}

