package com.coding.leetcode.dailycoding.practise;/*
  @created 5/16/20
  @Author  - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0 ;i<nums.length;i++){
            if(nums[i]>=0){
                nums[nums[i]-1]=-1*nums[nums[nums[i]-1]];
            }
        }
        List<Integer> numList = new ArrayList();
        for(int i=0 ;i<nums.length;i++){
            if(nums[i]>0){
                numList.add(i+1);
            }
        }
        return numList;
    }

}


/**

 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]


 */