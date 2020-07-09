package com.coding.leetcode.dynamicProgramming;/*
  @created 6/30/20
  @Author ** - Meeravali Shaik
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestCommonSubSeq {

    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        if(nums.length==1){
            return 1;
        }

        int[] longSubSeq = new int[nums.length];
        Arrays.fill(longSubSeq,1);
        int max = 1;
        for(int i=1; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[j] < nums[i]){
                   longSubSeq[i] = Math.max(longSubSeq[i],1+longSubSeq[j]);
                   max = Math.max(max,longSubSeq[i]);
                }
            }
        }


        int i=nums.length-1;
        int temp = max;
        List<Integer> result = new ArrayList<>();
        while (i>=0){
           if(longSubSeq[i]==temp){
               result.add(nums[i]);
               temp--;
           }
           i--;
        }
        result.forEach(System.out::println);
        return max;

    }

    public static void main(String[] args) {
        int[] input = {10,9,2,5,3,7,101,18};
        LongestCommonSubSeq commonSubSeq = new LongestCommonSubSeq();
        //System.out.println();
        commonSubSeq.largestDivisibleSubset(new int[]{1,2,3}).forEach(System.out::println);
    }


    public List<Integer> largestDivisibleSubset(int[] nums) {

        if(nums==null || nums.length==0){
            Collections.emptyList();
        }

        int[] longSubSet = new int[nums.length];
        Arrays.fill(longSubSet,1);
        Arrays.sort(nums);
        int max = 1;
        for(int i=1; i <nums.length ; i++){
            for(int j=0; j<i; j++){
                if(nums[i]%nums[j]==0 || nums[j]%nums[i]==0){
                    longSubSet[i] = Math.max(longSubSet[i],1+longSubSet[j]);
                    max = Math.max(max,longSubSet[i]);
                }
            }

        }

        var result = new ArrayList<Integer>();
        int i = nums.length-1;
        int previous = -1;
        while (i>=0){
            if(longSubSet[i]==max && (previous%nums[i]==0 || previous==-1)){
                result.add(nums[i]);
                max--;
                previous = nums[i];
            }
            i--;
        }
        Collections.reverse(result);
        return result;
    }

}

/**
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 *
 *
 *
 *
 *
 */

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
