package com.coding.leetcode.concurrency;/*
  @created 6/10/20
  @Author ** - Meeravali Shaik
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalExample {

    ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal
        .withInitial(() -> new SimpleDateFormat("dd-mm-yyyy"));

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ThreadLocalExample localExample = new ThreadLocalExample();
       for(int i=0; i<50; i++){
        executor.submit(()-> {
            String date = localExample.formatDate(new Date());
            System.out.println(date);
        });
        }
        System.out.println("Done");
        executor.shutdown();;
    }

    public String formatDate(Date date){
        SimpleDateFormat simpleDateFormat = threadLocal.get();
        return simpleDateFormat.format(date);
    }


}
