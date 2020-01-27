package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    Semaphore sem;
    CountDownLatch countDownLatch;
    int id;

    public Passenger(Semaphore sem, CountDownLatch countDownLatch, int id) {
        this.countDownLatch = countDownLatch;
        this.sem = sem;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            sem.acquire();

            System.out.println("Пассажир " + id + " " + "обслуживается на кассе и приобрел свой билет");
            sleep(1000);

            System.out.println("Пассажир " + id + " " + "выходит из кассы");
            sem.release();

            sleep(1000);
//            System.out.println("Пассажир " + id + " садиться в автобус");
//            sleep(1000);
            countDownLatch.countDown();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        super.run();
    }
}

