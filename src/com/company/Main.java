package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(4);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Passenger(sem, countDownLatch, i).start();
        }
        countDownLatch.await();

        System.out.println("Автобус уезжает");
    }
}
