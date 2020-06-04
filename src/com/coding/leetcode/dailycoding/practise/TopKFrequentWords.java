package com.coding.leetcode.dailycoding.practise;/*
  @created 5/22/20
  @Author  - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {


    public static List<String> topKFrequent(String[] words, int k) {
        var freqMap = new HashMap<String,Integer>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        var queue = new PriorityQueue<String>((o1, o2) -> {
            if (freqMap.get(o1) - freqMap.get(o2) == 0) {
                return o1.compareTo(o2);
            }
            return freqMap.get(o1) - freqMap.get(o2);
        });

        for(var word : freqMap.keySet()){
            queue.offer(word);
            if(queue.size()>k) queue.poll();
        }
        var result= new ArrayList<String>();
        while (!queue.isEmpty()){
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        String[] input = new String[] {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(input,2));
        input = new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(topKFrequent(input,4));
    }

}
