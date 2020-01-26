package com.company;

import java.util.concurrent.CountDownLatch;
import static com.company.Main.LATCH;

public class Bus extends Thread {
    public static final int  PASSENGERS_COUNT = 100;
    private int riderNumber;

    public Bus (int riderNumber) {
        this.riderNumber = riderNumber;

    }

    @Override
    public void run() {
        try {
            sleep(1000);
            System.out.println("Пассажир " + riderNumber + " " + " сел на автобус");
            sleep(1000);
            System.out.println(" " + "Пассажиры отправляются в Ош....");
        } catch (Exception e) {

    }
}
}