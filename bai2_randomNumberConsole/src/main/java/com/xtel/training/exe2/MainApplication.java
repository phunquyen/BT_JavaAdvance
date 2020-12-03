package com.xtel.training.exe2;

import com.xtel.training.exe2.thread.PrintNumberThread;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class MainApplication {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int second;
        final PrintNumberThread printNumberThread = new PrintNumberThread();

        System.out.print("Nhap so giay dung in so:");
        try {
            second = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.print("Sai so! Moi nhap lai: ");
            return;
        }
        if (second <= 0) return;

        System.out.println("Bat dau in so ra man hinh");
        printNumberThread.start();

        TimerTask stopThreadPrintNumber = new TimerTask() {
            public void run() {
                printNumberThread.setStop();
                System.out.println("Stop !!!");
            }
        };
        Timer timer = new Timer();
        timer.schedule(stopThreadPrintNumber, second * 1000);
    }
}
