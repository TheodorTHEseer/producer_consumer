package com.company.imitators;

import java.util.ArrayDeque;

public class ConsumerM implements Runnable{

    private ArrayDeque<String> arrayDeque;
    private final String name="\u001B[34mConsumerM: \u001B[0m";

    public ConsumerM(ArrayDeque<String> arrayDeque) {
        this.arrayDeque = arrayDeque;
    }

    @Override
    public void run() {
        System.out.println(name+"Поток-потребитель начал существование");
        synchronized (arrayDeque){
            System.out.println(name+"Тут поток-потребитель начал воспроизвдение из буфера");
            while (!arrayDeque.isEmpty())
                System.out.println(name+arrayDeque.pollFirst());
        }
        System.out.println(name+"Поток-потребитель закончил существование");
        Thread.interrupted();

    }
}
