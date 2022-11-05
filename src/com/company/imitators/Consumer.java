package com.company.imitators;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private ArrayDeque<String> arrayDeque;
    private Semaphore semaphore;
    private int bufferCapacity;
    private final String name="\u001B[34mConsumer: \u001B[0m";

    public Consumer(ArrayDeque<String> arrayDeque, Semaphore semaphore,int bufferCapacity){
        this.arrayDeque=arrayDeque;
        this.semaphore = semaphore;
        this.bufferCapacity=bufferCapacity;
    }

    @Override
    public void run() {
        System.out.println(name+"Поток-потребитель начал существование");
        try {
            while (arrayDeque.size()<bufferCapacity){
                semaphore.acquire();
                System.out.println(name+"читает");
                System.out.println(name+arrayDeque.getLast());
                System.out.println(name+"не читает");
                semaphore.release();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            semaphore.release();
        }
        System.out.println(name+"Поток-потребитель закончил существование");
        Thread.interrupted();
    }
}
