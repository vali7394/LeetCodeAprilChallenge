package com.coding.leetcode.challenge.May.week1;/*
  @created 5/6/20
  @Author - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 */
public class MajorityElement {

    // Time - O(2N) - O(n) Space - O(n)
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> majorMap = new HashMap<>();
        for(int i : nums){
            if(majorMap.containsKey(i)){
                majorMap.put(i,majorMap.get(i)+1);
            }else{
                majorMap.put(i,1);
            }
        }
        int result = 0;
        for(Map.Entry<Integer,Integer> entry : majorMap.entrySet()){
            if(entry.getValue()>(nums.length)/2){
                return entry.getKey();
            }
        }
        return result;
    }


    // TC- O(n) Space O(1)
    private int majorityElementBetter(int[] input){

        Integer majority = 0;
        int count = 0;

        for(int i : input){
            if(count==0){
                majority = i;
            }
            count+=(i==majority) ? 1:-1;
        }
        return majority;
    }

}
