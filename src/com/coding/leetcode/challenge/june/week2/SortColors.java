package com.coding.leetcode.challenge.june.week2;/*
  @created 6/11/20
  @Author ** - Meeravali Shaik
 */

public class SortColors {

    public void sortColors(int[] nums) {
        var low = 0; var mid = 0; var high = nums.length-1;
        while (mid<=high){
            if(nums[mid]==0){
                swap(low++,mid++,nums);
            } else if(nums[mid]==1){
                mid++;
            } else {
                swap(mid,high--,nums);
            }
        }

    }

    public void swap(int low, int high,int[] nums){
        var temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public void sortColorsSimple(int[] nums){
        var Zeros = 0;var ones = 0;var twos = 0; var i = 0;
        for (var num : nums) {
            if (num == 0) {
                Zeros++;
            } else if (num == 1) {
                ones++;
            } else {
                twos++;
            }
        }
        while (Zeros > 0) {
            nums[i] = 0;
            i++;
            Zeros--;
        }
        while (ones > 0) {
            nums[i] = 1;
            i++;
            ones--;
        }
        while (twos > 0) {
            nums[i] = 2;
            i++;
            twos--;
        }

    }

}


/**
 Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note: You are not suppose to use the library's sort function for this problem.

 Example:

 Input: [2,0,2,1,1,0]
 Output: [0,0,1,1,2,2]
 Follow up:

 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 Could you come up with a one-pass algorithm using only constant space?
 **/