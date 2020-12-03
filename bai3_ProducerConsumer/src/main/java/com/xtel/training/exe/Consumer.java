package com.xtel.training.exe;

import org.apache.log4j.Logger;

public class Consumer implements Runnable{
    Logger logger = Logger.getLogger(Consumer.class);
    private final BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    public void run() {
        try {
            while (true) {
                logger.info("take from queue");
                queue.take();
                logger.info("Consumer - Queue size() = " + queue.size());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
