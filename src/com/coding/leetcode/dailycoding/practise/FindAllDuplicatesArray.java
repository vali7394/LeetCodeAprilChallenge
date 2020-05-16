package com.coding.leetcode.dailycoding.practise;/*
  @created 5/16/20
  @Author b008245 - Meeravali Shaik 
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesArray {

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> duplicates = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = -nums[index];
            } else {
                duplicates.add(Math.abs(nums[i]));
            }

        }
        return duplicates;
    }

    public static void main(String[] args) {
        FindAllDuplicatesArray duplicatesArray = new FindAllDuplicatesArray();
        System.out.println(duplicatesArray.findDuplicates(new int[]{4,3,2,7,8,2,3,1}));
    }


}

/**

 Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements that appear twice in this array.

 Could you do it without extra space and in O(n) runtime?

 Example:
 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [2,3]


 */