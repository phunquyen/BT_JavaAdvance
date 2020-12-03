package com.xtel.training.exe;

public class MainApplication {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>();

        Producer producer = new Producer(queue);

        new Thread(producer).start();

        Thread.sleep(1000);
        Consumer consumer1 = new Consumer(queue);
        new Thread(consumer1).start();
    }
}
