package com.coding.leetcode.concurrency;/*
  @created 6/7/20
  @Author ** - Meeravali Shaik
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoreExample {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(50);
        Semaphore semaphore = new Semaphore(3,true);

        Thread thread = new Thread(new Task(semaphore));
        Thread threadOne = new Thread(new Task(semaphore));
        Thread threadTwo = new Thread(new Task(semaphore));
        Thread threadThree = new Thread(new Task(semaphore));
        Thread thread4 = new Thread(new Task(semaphore));
        Thread thread5 = new Thread(new Task(semaphore));
        Thread thread6 = new Thread(new Task(semaphore));
        thread.start();
        threadOne.start(); threadTwo.start();
        threadThree.start();
        thread4.start();
        thread6.start();
        thread5.start();

       threadPool.shutdown();
       threadPool.awaitTermination(10, TimeUnit.MINUTES);
    }

}

class Task implements Runnable{
        Semaphore semaphore;
    public Task(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Semaphore start " + Thread.currentThread().getName());
        semaphore.acquireUninterruptibly();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Semaphore completed " + Thread.currentThread().getName());
        semaphore.release();
    }
}