package com.coding.leetcode.dailycoding.practise;
/*
  @created 6/7/20
  @Author ** - Meeravali Shaik
 */

public class MaximumSumNonAdjacent {
    int[] mem;
    public int maxSum(int[] input){
        mem = new int[input.length];
        maxSumHelper(input,input.length-1);
        return 0;
    }



    private int maxSumHelper(int[] i, int j) {
        if (j == 0) {
            return i[0];
        }
        if (j == 1) {
            return i[1];
        }
        if(mem[j]!=0){
            return mem[j];
        }
        mem[j] = Math.max(maxSumHelper(i, j - 2) + i[j], maxSumHelper(i, j - 1));
        return mem[j];
    }


}


/**
 Given an array of integers, find a maximum sum of non-adjacent elements.

 For example, inputs [1, 0, 3, 9, 2] should return 10 (1 + 9).
 */