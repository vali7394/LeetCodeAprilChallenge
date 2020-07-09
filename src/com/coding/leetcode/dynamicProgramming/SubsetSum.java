package com.coding.leetcode.dynamicProgramming;/*
  @created 6/30/20
  @Author ** - Meeravali Shaik
 */

import java.util.Arrays;
import java.util.stream.Stream;

public class SubsetSum {

    public boolean subsetFinder(int[] input, int sum) {
        return subSetFinderHelper(input, sum - input[input.length - 1], input.length - 2)
            || subSetFinderHelper(input, sum, input.length - 2);
    }

    public boolean subSetFinderHelper(int[] input, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n <= 0) {
            return false;
        }
        return subSetFinderHelper(input, sum - input[n], n - 1) || subSetFinderHelper(input, sum,
            n - 1);
    }

    public static void main(String[] args) {
        int[] input = new int[]{3, 34, 4, 12, 5, 2};
        SubsetSum subsetSum = new SubsetSum();
       // System.out.println(subsetSum.subsetFinder(input, 9));
        System.out.println(subsetSum.partionSubSetSub(input));
    }

    public boolean subsetSumDp(int[] input, int sum) {
        boolean[][] dp = new boolean[input.length + 1][sum + 1];

        for (int i = 0; i <= input.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {

            for (int j = 1; j <= sum; j++) {

                if (j < input[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - input[i-1]];
                }
            }

        }
        return dp[input.length][sum];

    }

    public boolean partionSubSetSub(int[] input){
        int sum = Arrays.stream(input).reduce(0,Integer::sum);
        if(sum%2!=0){
            return false;
        }
        return canSplitIntoSubSet(input,sum/2);
    }

    private boolean canSplitIntoSubSet(int[] input, int sum){

    boolean[][] dp = new boolean[input.length+1][sum+1];

        for(int i = 0; i < input.length; i++)
        {
            if(sum < input[i])
                return false;
        }

    for(int i=0; i<=input.length; i++){
        dp[i][0] = true;
    }

    for(int i=1; i<=input.length; i++){
        for(int j=1; j<=sum; j++){

            if(j<input[i]){
                dp[i][j] = dp[i-1][j];
            } else {
                dp[i][j] = dp[i-1][j] || dp[i-1][j-input[i]];
            }
        }
    }
    return dp[input.length][sum];
    }

    public boolean partionSubSetSub(int[] input,int k){
        int sum = Arrays.stream(input).reduce(0,Integer::sum);
        if(sum%k!=0){
            return false;
        }

        int targetSum = sum/k;

        for(int i=0; i<input.length;i++){
            if(targetSum<input[i]){
                return false;
            }
        }
        return canSplitIntoSubSet(input,targetSum);
    }

}

/**
 Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 Example:

 Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 Output: True
 There is a subset (4, 5) with sum 9.

 Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 Output: False
 There is no subset that add up to 30.
 **/

/**
 Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:

 Each of the array element will not exceed 100.
 The array size will not exceed 200.


 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].


 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.
 **/