package com.coding.leetcode.challenge.june.week4;/*
  @created 6/22/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map.Entry;

public class SingleNumberII {


    public int singleNumber(int[] nums) {
        var map = new HashMap<Integer,Integer>();
        for(var i : nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else{
                map.put(i,1);
            }
        }
        for(Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SingleNumberII numberII = new SingleNumberII();
        numberII.singleNumber(new int[]{2,2,3,2});
    }
}


/**
 Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

 Note:

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:

 Input: [2,2,3,2]
 Output: 3
 Example 2:

 Input: [0,1,0,1,0,1,99]
 Output: 99
 **/