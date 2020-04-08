package com.coding.leetcode.challenge.april.week1;

/*
  @created 4/3/20
  @Author Meeravali Shaik
 */


/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 *
 */
public class MaximumSubarrayDay3 {

    public static void main(String[] args) {
        int input[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSumAlt(input));
    }


    private static int maxSum(int[] input) {

        int maxSum = Integer.MIN_VALUE;
        int maxEnd = 0;
        for (int i = 0; i < input.length; i++) {
            maxEnd = maxEnd + input[i];
            if(maxSum < maxEnd) {
                maxSum = maxEnd;
            }
            if(maxEnd < 0){
                maxEnd= 0;
            }
        }

        return maxSum;
    }

    private static int maxSumAlt(int[] input){
        int maxSum = Integer.MIN_VALUE;
        int currenSum = 0;

        for(int i=0; i < input.length;i++) {
            currenSum = currenSum+input[i];
            maxSum = Math.max(maxSum,currenSum);
            currenSum = Math.max(currenSum,0);
        }
        return maxSum;
    }



}
