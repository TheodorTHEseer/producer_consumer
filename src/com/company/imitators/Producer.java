package com.company.imitators;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private ArrayDeque<String> arrayDeque;
    private Semaphore semaphore;
    private int bufferCapacity;
    private final String name="\u001B[31mProducer: \u001B[0m";

    public Producer (ArrayDeque<String> arrayDeque, Semaphore semaphore, int bufferCapacity){
        this.arrayDeque=arrayDeque;
        this.semaphore=semaphore;
        this.bufferCapacity=bufferCapacity;
    }

    @Override
    public void run() {
        System.out.println(name+"Поток-производитель начал существование");
        try {
            while (arrayDeque.size()<bufferCapacity){
                semaphore.acquire();
                System.out.println(name+"пишет");
                arrayDeque.add("NODE: "+arrayDeque.size());
                System.out.println(name+"не пишет");
                semaphore.release();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            semaphore.release();
        }
        System.out.println(name+"Поток-производитель закончил существование");
        Thread.interrupted();
    }
}
