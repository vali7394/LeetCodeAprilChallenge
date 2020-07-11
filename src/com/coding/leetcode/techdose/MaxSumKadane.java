package com.coding.leetcode.techdose;/*
  @created 7/9/20
  @Author b008245 - Meeravali Shaik 
 */

public class MaxSumKadane {


    public int maxSubArray(int[] input) {
        if(input==null || input.length==0){
            return 0;
        }

        int maxSum=Integer.MIN_VALUE;
        int curSum=0;

        for(int element : input){
            curSum+=element;
            maxSum = Math.max(curSum,maxSum);
            curSum=Math.max(curSum,0);
        }
        return maxSum;
    }
}
