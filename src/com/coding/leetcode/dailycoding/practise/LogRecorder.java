package com.coding.leetcode.dailycoding.practise;/*
  @created 4/9/20
  @Author Meeravali Shaik
 */

/**
 *You run an e-commerce website and want to record the last N order ids in a log.
 * Implement a data structure to accomplish this, with the following API:
 *
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 *
 */

public class LogRecorder {

    int[] circularBuffer ;
    int maxSize;
    int count;

    LogRecorder(int maxSize){
        circularBuffer = new int[maxSize];
        this.maxSize = maxSize;
        count = 0;
    }


    public void record(int logId){
        circularBuffer[count] = logId;
        count = (count+1)%maxSize;
    }

    public int getLastIthLogId(int i){
        return circularBuffer[(count-i+maxSize)%maxSize];
    }

}
