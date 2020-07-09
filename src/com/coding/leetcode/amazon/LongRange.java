package com.coding.leetcode.amazon;/*
  @created 6/18/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashMap;

public class LongRange {

    private int[] findLongRange(int[] input){
        var map = new HashMap<Integer,Boolean>();
        for(var i : input){
            map.put(i,false);
        }
        int[] result = new int[2];
        int longRange = Integer.MIN_VALUE;
        for(var i : input){
            if(!map.get(i)) {
                int start = i-1;
                int end = i+1;

                while (map.containsKey(start)){
                    map.put(start,true);
                    start-=1;
                }

                while (map.containsKey(end)){
                    map.put(end,true);
                    end+=1;
                }
                start+=1;
                end-=1;
                if(end-start>longRange){
                    longRange = end-start;
                    result = new int[]{start,end};
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        LongRange longRange = new LongRange();
        for(int i : longRange.findLongRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 5, 12, 6})){
            System.out.println(i);
        };
    }

}
