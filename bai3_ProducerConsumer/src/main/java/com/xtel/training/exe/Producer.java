package com.xtel.training.exe;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    Logger logger = Logger.getLogger(Producer.class);
    private final BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            while (true) {
                logger.info("put to queue");
                queue.put(produce());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Integer produce() throws InterruptedException {
        Thread.sleep(100);
        return ThreadLocalRandom.current().nextInt(1,10);
    }
}
