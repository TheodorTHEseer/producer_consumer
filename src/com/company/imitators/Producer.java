package com.company.imitators;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private ArrayDeque<String> arrayDeque;
    private Semaphore semaphore;
    private int bufferCapacity;

    public Producer (ArrayDeque<String> arrayDeque, Semaphore semaphore, int bufferCapacity){
        this.arrayDeque=arrayDeque;
        this.semaphore=semaphore;
        this.bufferCapacity=bufferCapacity;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            for(;bufferCapacity>0;bufferCapacity--)
                arrayDeque.add("NODE");
            semaphore.release();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            semaphore.release();
        }
        Thread.interrupted();
    }
}
