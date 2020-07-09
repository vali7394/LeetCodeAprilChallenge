package com.coding.leetcode.challenge.june.week2;/*
  @created 6/10/20
  @Author ** - Meeravali Shaik
 */

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        var length = nums.length;
        if(length==0){
            return -1;
        }

        var low = 0;
        var high = length;
        int result = -1;
        while (low < high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid] > target){
                high = mid;
            } else {
                low = mid+1;
            }
            result= low;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
        System.out.println(searchInsert(new int[]{1,3,5,6},7));
       System.out.println(searchInsert(new int[]{1,3,5,6},0));
    }


}


/**

 Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Example 1:

 Input: [1,3,5,6], 5
 Output: 2
 Example 2:

 Input: [1,3,5,6], 2
 Output: 1
 Example 3:

 Input: [1,3,5,6], 7
 Output: 4
 Example 4:

 Input: [1,3,5,6], 0
 Output: 0

 */