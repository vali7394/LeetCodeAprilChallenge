package com.coding.leetcode.challenge.april.week3;/*
  @created 4/15/20
  @Author  Meeravali Shaik
 */

/**
 * Given an array nums of n integers where n > 1,
 * return an array
 *   Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 */

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        for(int i : productArrayExceptItself(input)){
            System.out.println(i);
        }
    }


    // Time O(n+n+n) = O(3n) = O(n) space O(2n) = O(n)
    private static int[] productArrayExceptItself(int[] input){
        if(input.length==0){
            return new int[]{};
        }
        int size = input.length;
        int[] leftProduct = new int[size];
        int[] rightProduct = new int[size];
        leftProduct[0] = 1;
        rightProduct[size-1] = 1;
        for(int i=1; i<size;i++){
            leftProduct[i] = leftProduct[i-1] * input[i-1];
        }

        for(int i=size-2;i>=0;i--){
            rightProduct[i] = rightProduct[i+1]*input[i+1];
        }

        int result[] = new int[size];

        for(int i=0 ; i<size;i++){
            result[i] = leftProduct[i]*rightProduct[i];
        }
        return result;
    }

}
