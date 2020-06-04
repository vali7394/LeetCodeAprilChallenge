package com.coding.leetcode.dailycoding.practise;/*
  @created 5/23/20
  @Author  - Meeravali Shaik
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestInStream {
    int totalQueueSize = 0;
    PriorityQueue<Integer> queue ;

    public KthLargestInStream(int k, int[] nums) {
        this.totalQueueSize = k;
        this.queue = new PriorityQueue<>(totalQueueSize);
        for(var element : nums){
            add(element);
        }
    }

    public int add(int val) {
        if(queue.size() <totalQueueSize){
            queue.offer(val);
        }else if(queue.peek() < val){
            queue.poll();
            queue.offer(val);
        }
        return  queue.peek();
    }

    public static void main(String[] args) {
        int[] input = new int[]{4,5,8,2};
        KthLargestInStream largestInStream = new KthLargestInStream(3,input);
        System.out.println(largestInStream.add(3));
        System.out.println(largestInStream.add(5));
        System.out.println(largestInStream.add(10));
        System.out.println(largestInStream.add(9));
        System.out.println(largestInStream.add(4));
    }
}


/**

 Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

 Example:

 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5
 kthLargest.add(10);  // returns 5
 kthLargest.add(9);   // returns 8
 kthLargest.add(4);   // returns 8
 Note:
 You may assume that nums' length ≥ k-1 and k ≥ 1.

 */

