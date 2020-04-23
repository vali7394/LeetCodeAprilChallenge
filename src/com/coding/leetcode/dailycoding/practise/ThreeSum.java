package com.coding.leetcode.dailycoding.practise;/*
  @created 4/21/20
  @Author  Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = K? Find all unique triplets in the array which gives the sum of K.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [20,303,3,4,25], K = 32
 *
 * A solution set is:
 * [
 *   [3,4,25]
 * ]
 *
 */

public class ThreeSum {

    public static void main(String[] args) {
        int[] input = {20,303,3,4,25};
        for(int i : findThreeSum(input,32)){
            System.out.println(i);
        }
    }


    private static int[] findThreeSum(int[] input, int target){

        for(int i=0 ; i<input.length-2;i++){
            int temp = target - input[i];
            Map<Integer,Integer> lookUpMap = new HashMap<>();
            for(int j=1;j<input.length;j++){

                if(lookUpMap.containsKey(input[j])){
                    return new int[]{input[i],input[j],lookUpMap.get(input[j])};
                } else {
                    lookUpMap.put(temp-input[j], input[j]);
                }

            }
        }
        return new int[]{};
    }

}
