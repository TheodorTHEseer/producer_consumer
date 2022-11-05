package com.company;

import com.company.imitators.Consumer;
import com.company.imitators.Producer;

import java.nio.Buffer;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1, true);
        CircularFifoBuffer circularFifoBuffer = new CircularFifoBuffer(Integer.getInteger(args[0]));

        new Thread(new Producer(circularFifoBuffer, semaphore)).start();
        new Thread(new Consumer(circularFifoBuffer, semaphore)).start();
    }
}
