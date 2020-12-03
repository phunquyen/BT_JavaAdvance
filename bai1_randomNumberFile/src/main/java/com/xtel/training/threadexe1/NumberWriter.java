package com.xtel.training.threadexe1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class NumberWriter extends AbsThread{
    private static String filePath = "output.txt";
    File file = new File(filePath);
    public NumberProducer numberProducer;

    protected void doSomething() throws Exception {
        if (file.exists()) {
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(filePath, true));
                out.write(String.valueOf(numberProducer.atomicNumber));
//                logger.debug("Number written is : "+numberProducer.atomicNumber);
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
                logger.error(e);
            }
        } else {
            logger.warn(String.format("File not found"));
        }
        numberProducer.notifyMe();
    }

    public void setNumberProducer(NumberProducer numberProducer) {
        this.numberProducer = numberProducer;
    }
}
