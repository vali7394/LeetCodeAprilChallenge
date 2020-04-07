package com.coding.leetcode.dailycoding.practise;/*
  @created 4/4/20
  @Author Meeravali Shaik
 */

/**
 * Given an  integer array, find the smallest missing positive integer.
 *  sorted
 *  Example 1:
 *  Input[1,2,3,5,6,7,8,9]
 *
 * unsorted
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 *
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 *
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 *
 *
 */

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 6, 7, 8, 9};
      //  System.out.println(sortedArrayBinarySearch(input));
        int[] one = {7,8,9,11,12};
        System.out.println(findMissingPositiveNo(one));
        int[] two = {3,4,-1,1};
        System.out.println(findMissingPositiveNo(two));
        int[] three = {1,2,0};
        System.out.println(findMissingPositiveNo(three));

    }

    private static int sortedArrayLinear(int[] input){
        int missingNo = 0;

        for(int i=0; i<input.length;i++) {

            if(input[i]!=i+1) {
                return i+1;
            }

        }
        return missingNo;

    }

    private static int sortedArrayBinarySearch(int[] input){
        int missingNo = 0;
        int left = 0;
        int right = input.length-1;

        while (left<right){
            int mid = (left+right)/2;
            if((mid+1)!=input[mid]) {
                missingNo = mid+1;
                right = mid;
            } else {
                left = mid;
            }
        }

        return missingNo;

    }

    private static int findMissingPositiveNo(int[] input) {
        int n = input.length;
        for (int i = 0; i < n; i++) {
            if (input[i] <= 0 || input[i] > n) {
                input[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int num = Math.abs(input[i]);
            if (num > n) {
                continue;
            }
            num--;
            if(input[num]>0) {
                input[num] = -1 * input[num];
            }
        }

        for (int i = 0; i < n; i++) {

            if (input[i] >= 0) {
                return i + 1;
            }

        }
        return n + 1;

    }

}
