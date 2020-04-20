package com.coding.leetcode.challenge.april.week3;/*
  @created 4/19/20
  @Author  - Meeravali Shaik
 */

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 *
 *
 */

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] input = {4,5,6,7,0,1,2};
        System.out.println(searchInSortedArray(input,3));
    }


    private static int searchInSortedArray(int[] input, int k){

        int low  = 0;
        int high = input.length-1;

        while(low<=high){
           int mid = (low+high)/2;
            if(k==input[mid]){
                return mid;
            }
            if(input[mid]<=input[high]){
                if(k>input[mid] && k<=input[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }

            } else if (input[low]<=input[mid]) {
                if(k>=input[low] && k<input[mid]){
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }

        }
        return -1;
    }



}
