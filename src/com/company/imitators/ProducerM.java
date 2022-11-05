package com.company.imitators;

import java.util.ArrayDeque;

public class ProducerM implements Runnable{

    private ArrayDeque <String> arrayDeque;
    private int bufferCapacity;
    private final String name = "\u001B[31mProducerM: \u001B[0m";

    public ProducerM (ArrayDeque<String> arrayDeque, int bufferCapacity){
        this.arrayDeque=arrayDeque;
        this.bufferCapacity=bufferCapacity;
    }
    @Override
    public void run() { //Все паузы для наглядности
        System.out.println(name+"Поток-производитель(M) начал существование");
        synchronized (arrayDeque){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+"Поток-производитель(M) начал запись");
            while (arrayDeque.size()<bufferCapacity)
                arrayDeque.add("NODE: " + arrayDeque.size());
            System.out.println(name+"Поток-производитель(M) закончил запись");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"Поток-производитель(M) закончил существование");
        Thread.interrupted();
    }
}
