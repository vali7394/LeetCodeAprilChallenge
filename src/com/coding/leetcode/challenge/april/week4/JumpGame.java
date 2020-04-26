package com.coding.leetcode.challenge.april.week4;/*
  @created 4/25/20
  @Author  Meeravali Shaik
 */

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 *
 *
 */
public class JumpGame {

    public static void main(String[] args) {

        int[] input1 = {3,2,1,0,4};
        int[] input2 = {2,3,1,1,4};
        System.out.println(canJump(input1));
        System.out.println(canJump(input2));
    }

    private static boolean canJump(int[] input){
        if(input==null || input.length==0 || input[0]==0){
            return false;
        }
        int maxReachable = 0;
        for(int i=0; i<input.length;i++){
            if(maxReachable==input.length-1){
                return true;
            }
            maxReachable = Math.max(maxReachable,i+input[i]);
            if(maxReachable < i){
                return false;
            }

        }
        return false;
    }

}
