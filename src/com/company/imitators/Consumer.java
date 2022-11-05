package com.company.imitators;

import com.company.CircularFifoBuffer;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private CircularFifoBuffer circularFifoBuffer;
    private Semaphore semaphore;

    public Consumer(CircularFifoBuffer circularFifoBuffer, Semaphore semaphore){
        this.circularFifoBuffer = circularFifoBuffer;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            while (!circularFifoBuffer.isEmpty()){
                System.out.println(circularFifoBuffer.dequeue());
            }
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            semaphore.release();
        }
    }
}
