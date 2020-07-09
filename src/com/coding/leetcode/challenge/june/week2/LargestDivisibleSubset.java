package com.coding.leetcode.challenge.june.week2;

/*
  @created 6/13/20
  @Author ** - Meeravali Shaik
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        if(length==0){
            return Collections.emptyList();
        }else if(length==1){
            return List.of(nums[0]);
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] =1;
        int max = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < 1 + dp[j]) {
                    dp[i] = 1 + dp[j];
                    max = Math.max(max, dp[i]);
                }
            }
        }

        int previous = -1;
        List<Integer> subSet = new ArrayList<>();

        for(var i=length-1;i>=0;i--){
            if(dp[i]==max && (previous%nums[i]==0 || previous==-1)){
                subSet.add(nums[i]);
                max--;
                previous = nums[i];
            }

        }
        return subSet;
    }

}


/**
 Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

 Si % Sj = 0 or Sj % Si = 0.

 If there are multiple solutions, return any subset is fine.

 Example 1:

 Input: [1,2,3]
 Output: [1,2] (of course, [1,3] will also be ok)
 Example 2:

 Input: [1,2,4,8]
 Output: [1,2,4,8]
 **/