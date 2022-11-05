package com.company.imitators;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private ArrayDeque<String> arrayDeque;
    private Semaphore semaphore;
    private final String name="\u001B[34mConsumer: \u001B[0m";

    public Consumer(ArrayDeque<String> arrayDeque, Semaphore semaphore){
        this.arrayDeque=arrayDeque;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println(name+"Поток-потребитель начал существование");
        try {
            semaphore.acquire();
            System.out.println(name+"Тут поток-потребитель начал воспроизвдение из буфера");
            while (!arrayDeque.isEmpty())
                System.out.println(name+arrayDeque.pollFirst());
            semaphore.release();
            System.out.println(name+"Тут поток-потребитель закончил воспроизведение и снял с семафора себя");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            semaphore.release();
        }
        System.out.println(name+"Поток-потребительМ закончил существование");
        Thread.interrupted();
    }
}
