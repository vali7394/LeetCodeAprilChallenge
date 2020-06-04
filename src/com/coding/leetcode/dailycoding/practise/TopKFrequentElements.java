package com.coding.leetcode.dailycoding.practise;/*
  @created 5/22/20
  @Author  - Meeravali Shaik
 */


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {


    public static int[] topKFrequent(int[] nums, int k) {

        var freqMap = new HashMap<Integer,Integer>();
        for(var element : nums){
            freqMap.put(element,freqMap.getOrDefault(element,0)+1);
        }

        var tracker = new PriorityQueue<Integer>(
            Comparator.comparing(freqMap::get));
        for(var element : freqMap.keySet()) {
            tracker.offer(element);
            if(tracker.size()>k){
                tracker.poll();
            }
        }
        int[] result = new int[k];
        var count = k-1;
        while (!tracker.isEmpty()){
            result[count] = tracker.poll();
            count--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,1,1,2,2,3};
        for(var result : topKFrequent(input,2)){
            System.out.println(result);
        }

         input = new int[]{1};
        for(var result : topKFrequent(input,1)){
            System.out.println(result);
        }
    }
}


/**
 *Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 *
 *
 *
 */