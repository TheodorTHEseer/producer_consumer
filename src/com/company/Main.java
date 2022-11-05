package com.company;

import com.company.imitators.Consumer;
import com.company.imitators.Producer;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1, true);

        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();

        int cap =10;

        //new Thread(new Producer(arrayDeque, semaphore, Integer.getInteger(args[0]))).start();
        new Thread(new Producer(arrayDeque, semaphore, cap)).start();
        new Thread(new Consumer(arrayDeque, semaphore)).start();
    }
}
