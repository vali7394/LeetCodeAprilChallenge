package com.coding.leetcode.concurrency;/*
  @created 6/17/20
  @Author ** - Meeravali Shaik
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxHeapAndMinHeapTest {

    public static void main(String[] args) {
        var maxQueue = new PriorityQueue<Integer>(3, Comparator.reverseOrder());
        var minQueue = new PriorityQueue<Integer>(3);

        for(int i=0; i<5;i++){
            maxQueue.offer(i);
            minQueue.offer(i);
            if (i > 2) {
               // maxQueue.poll();
                minQueue.poll();
            }

        }

       /* while (!maxQueue.isEmpty()){
            System.out.print(maxQueue.poll());
        }*/
        System.out.println();
        while (!minQueue.isEmpty()){
            System.out.print(minQueue.poll());
        }

    }

}
