package com.coding.leetcode.challenge.May.wee4;/*
  @created 5/26/20
  @Author  - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static int findMaxLength(int[] input) {
        var sumMap = new HashMap<Integer,Integer>();
        var maxConArray = 0;
        var sum=0;
        for(var i=0; i<input.length;i++){

            if(input[i]==0){
                sum-=1;
            } else {
                sum+=1;
            }

            if(sum==0){
                maxConArray = Math.max(maxConArray,i+1);
            } else if(sumMap.containsKey(sum)){
                maxConArray = Math.max(maxConArray,i-sumMap.get(sum));
            } else {
                sumMap.put(sum,i);
            }


        }
        return maxConArray;
    }

    public static void main(String[] args) {
        int[] input = {0,0,1,0,0,0,1,1};
        System.out.println(findMaxLength(input));
    }

}


/**

 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

 Example 1:
 Input: [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 Example 2:
 Input: [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 Note: The length of the given binary array will not exceed 50,000.
 */