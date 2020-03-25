package com.learn.concurrentprogramming.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by XJH on 2020/3/2.
 *
 * @Description:
 */
public class CyclicBarrierSample {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            // the command to execute when the barrier is tripped, or {@code null} if there is no action
            @Override
            public void run() {
                System.out.println("go again...");
            }
        });

        // 5个工作线程代表的更像是5辆车而不在是5个乘客
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new CyclicWorker(cyclicBarrier));
            t.start();
        }
    }

    static class CyclicWorker implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public CyclicWorker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                // 每个工作线程循环3次
                for (int i = 0; i < 3; i++) {
                    // 每循环一次
                    System.out.println(Thread.currentThread().getName() + " Executed...");
                    // 阻塞并等待cyclicBarrier达到阈值后释放，释放后调用回调函数。随后继续循环打印
                    cyclicBarrier.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

