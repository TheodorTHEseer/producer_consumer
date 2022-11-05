package com.company;

import com.company.imitators.Consumer;
import com.company.imitators.ConsumerM;
import com.company.imitators.Producer;
import com.company.imitators.ProducerM;

import java.util.ArrayDeque;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(1, true);

        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();

        new Thread(new Producer(arrayDeque, semaphore, Integer.valueOf(args[0]))).start();
        new Thread(new Consumer(arrayDeque, semaphore)).start();

        System.out.println("\u001B[32m"+Thread.currentThread().getName()+
                ": Сделаем паузу в секунду, чтобы не путать два типа синхронизации (симофоры и мьютекс)"+
                "\u001B[0m ");
        Thread.currentThread().sleep(1000);

        if (args.length>=2){

            switch (args[1]){
                case ("-m"):{
                    new Thread(new ProducerM(arrayDeque,Integer.valueOf(args[0]))).start();
                    new Thread(new ConsumerM(arrayDeque)).start();
                }
            }
        }
    }
}
