package com.learn.concurrentprogramming.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by XJH on 2020/3/3.
 *
 * @Description:
 */
public class ConsumerProducer {
    public static final String EXIT_MSG = "Good Bye";

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    static class Producer implements Runnable {
        private BlockingQueue<String> blockingQueue;

        public Producer(BlockingQueue<String> q) {
            this.blockingQueue = q;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(5L);
                    String msg = "Message" + i;
                    System.out.println("produced new item " + msg);
                    blockingQueue.put(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println("Time to say good bye");
                blockingQueue.put(EXIT_MSG);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {
        private BlockingQueue<String> blockingQueue;

        public Consumer(BlockingQueue<String> q) {
            this.blockingQueue = q;
        }

        @Override
        public void run() {
            String msg;
            try {
                while (!EXIT_MSG.equalsIgnoreCase(msg = blockingQueue.take())) {
                    System.out.println("Consumed item : " + msg);
                    Thread.sleep(10L);
                }
                System.out.println("Got exit msg : bye !");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
