package com.learn.test.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by XJH on 2020/1/9.
 *
 * @Description: 1. 非公平锁时，线程抢占成功确实不用再加入队列了，释放锁时他会调用release()唤醒head.next；
 * 2. 你说的这种情形，如果持有锁的线程release时异常，从源码上看，确实无法再通过LockSupport.unpark(s.thread)唤醒其他结点了，好像也没有其他机制来探测持有锁线程的异常状态。
 */
public class ExceptionWhenReleasing {

    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        for (int i = 0; i < 2; i++) {
            new MyThread(i, lock).start();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    private int index;
    private Lock lock;

    public MyThread(int index, Lock lock) {
        this.index = index;
        this.lock = lock;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("adu-" + index);
        System.out.println("before lock " + index);

        lock.lock();

        try {
            System.out.println("locking " + index);
            if (index == 0) {
                Thread.sleep(3000); //线程0 sleep 3秒
            } else {
                Thread.sleep(300000); //线程0 sleep 300秒
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock(); //通过debug，让线程0在unlock()->release()->unparkSuccessor(Node node)时，强制让node=null，从而让"int ws = node.waitStatus;"抛出NPE，无法执行后续的unpark操作。
            System.out.println("after lock " + index);
        }
    }
}
