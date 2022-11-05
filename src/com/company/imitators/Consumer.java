package com.company.imitators;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private ArrayDeque<String> arrayDeque;
    private Semaphore semaphore;

    public Consumer(ArrayDeque<String> arrayDeque, Semaphore semaphore){
        this.arrayDeque=arrayDeque;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            while (!arrayDeque.isEmpty())
                System.out.println(arrayDeque.pollFirst());
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            semaphore.release();
        }
        Thread.interrupted();
    }
}
