package com.coding.leetcode.challenge.april.week4;/*
  @created 4/22/20
  @Author  Meeravali Shaik
 */


import java.util.ArrayList;
import java.util.List;

/**Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

    Example 1:
    Input:nums = [1,1,1], k = 2
    Output: 2
    Note:
    The length of the array is in range [1, 20,000].
    The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

 **/

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] input = {1,2,3};
        System.out.println(sumArraySumEqualsK(input,3));
    }

    private static int sumArraySumEqualsK(int[] input, int target){
        int n = input.length;
        int[] sum = new int[n+1];
        sum[0] = 0;

        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1]+input[i-1];
        }
        int totalCount = 0;
        for(int i=0; i<n;i++){
            for(int j=i+1; j<n-1;j++){
            if(sum[j]-sum[i]==target){
                totalCount++;
            }
        }

        }
        return totalCount;

    }

}
