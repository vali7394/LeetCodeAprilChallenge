package com.coding.leetcode.challenge.april.week2;/*
  @created 4/13/20
  @Author - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Note: The length of the given binary array will not exceed 50,000.
 *
 *
 */
public class ContiguousArray {

    public static void main(String[] args) {
        int[] input = {0,1,0};
        System.out.println(contiguousArray(input));
    }


    private static int contiguousArray(int[] input) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        int sum = 0;
        int longestConArray = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                sum -= 1;
            }else {
                sum+=1;
            }

            if (sum == 0) {
                longestConArray = Math.max(longestConArray, i + 1);
            } else if (sumMap.containsKey(sum)) {
                longestConArray = Math.max(longestConArray, i - sumMap.get(sum));
            } else {
                sumMap.put(sum, i);
            }
        }
        return longestConArray;
    }
}
