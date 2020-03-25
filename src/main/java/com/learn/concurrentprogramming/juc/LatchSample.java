package com.learn.concurrentprogramming.juc;

import java.util.concurrent.CountDownLatch;

/**
 * Created by XJH on 2020/3/2.
 *
 * @Description: 10个人分2个批次
 * CountDownLatch(不能自动重置,无法复用) 一般基本操作组合是 countDown/await 操作的是事件
 */
public class LatchSample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new FirstBatchWorker(latch));
            t.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SecondBatchWorker(latch));
            t.start();
        }

        while (latch.getCount() != 1) {
            Thread.sleep(100L);
        }

        System.out.println("Wait for first batch finish");
        latch.countDown();
    }
}

class FirstBatchWorker implements Runnable {
    private CountDownLatch latch;

    public FirstBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("FirstBatch executed..." + Thread.currentThread().getName());
        latch.countDown();
    }
}

// 第一批用countdown去触发latch减一。第二批次等待latch达到临界点释放栅栏然后执行
class SecondBatchWorker implements Runnable {
    private CountDownLatch latch;

    public SecondBatchWorker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            // 后一批次的线程进行 await，等待前一批countDown 足够多次。
            latch.await();
            System.out.println("SecondBatch executed...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}