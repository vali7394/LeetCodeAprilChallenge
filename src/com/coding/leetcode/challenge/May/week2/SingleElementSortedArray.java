package com.coding.leetcode.challenge.May.week2;/*
  @created 5/12/20
  @Author - Meeravali Shaik
 */

public class SingleElementSortedArray {

    public static void main(String[] args) {
        int[] inputOne = {1,1,2,3,3,4,4,8,8};
        int[] inputTwo = {3,3,7,7,10,11,11};
       System.out.println(singleNonDuplicateXor(inputOne));
        System.out.println(singleNonDuplicate(inputOne));
        System.out.println(singleNonDuplicateXor(inputTwo));
      System.out.println(singleNonDuplicate(inputTwo));

    }


    public static int singleNonDuplicateXor(int[] nums) {
        int result = 0;
        for(int i : nums){
            result=result^i;
        }

        return result;
    }

    public static int singleNonDuplicate(int[] nums) {

        if (nums.length == 1 || nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if (mid > 0 && mid < nums.length-1 && nums[mid - 1] != nums[mid]
                && nums[mid + 1] != nums[mid]) {
                return nums[mid];
            } else if (mid >= 0 && ((((mid % 2 == 0) && (nums[mid - 1] == nums[mid]))) || (
                mid % 2 != 0 && (nums[mid - 1] != nums[mid])))) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return Integer.MIN_VALUE;
    }


}


/**

 You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 Example 1:

 Input: [1,1,2,3,3,4,4,8,8]
 Output: 2
 Example 2:

 Input: [3,3,7,7,10,11,11]
 Output: 10
 */