package com.coding.leetcode.amazon;/*
  @created 6/18/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashMap;

public class TwoSum {


    private int[] twoSumSearch(int[] input , int target){
        var map = new HashMap<Integer,Integer>();
        target = target-30;
        int[] result = new int[2];
        for(var i=0; i<input.length; i++){
            if(map.containsKey(input[i])){
                var first = input[i];
                var second = input[map.get(input[i])];
                if (result[0]!=0 && (first > result[0] && first > result[1]) || (second > result[0]
                    && second > result[1])) {
                    result = new int[]{i, map.get(input[i])};
                }else {
                    result = new int[]{i, map.get(input[i])};
                }
            }else {
                map.put(target-input[i],i);
            }
        }
        return result;
    }

    public static void main(String ... args){
        var twoSum = new TwoSum();
       int[] result =  twoSum.twoSumSearch(new int[]{20, 50, 40, 25, 30, 10},90);
       for(var i : result){
           System.out.println(i);
       }

    }


}


/**

 Given a list of positive integers nums and an int target, return indices of the two numbers such that they add up to a target - 30.

 Conditions:

 You will pick exactly 2 numbers.
 You cannot pick the same element twice.
 If you have muliple pairs, select the pair with the largest number.
 Example 1:

 Input: nums = [1, 10, 25, 35, 60], target = 90
 Output: [2, 3]
 Explanation:
 nums[2] + nums[3] = 25 + 35 = 60 = 90 - 30
 Example 2:

 Input: nums = [20, 50, 40, 25, 30, 10], target = 90
 Output: [1, 5]
 Explanation:
 nums[0] + nums[2] = 20 + 40 = 60 = 90 - 30
 nums[1] + nums[5] = 50 + 10 = 60 = 90 - 30
 You should return the pair with the largest number.

 **/