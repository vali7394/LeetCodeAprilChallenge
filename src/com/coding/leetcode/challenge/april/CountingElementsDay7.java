package com.coding.leetcode.challenge.april;
/*
  @created 4/7/20
  @Author - Meeravali Shaik
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr. If there're duplicates in arr, count them seperately.
 * Example 1:
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 * Example 2:
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 * Example 3:
 *
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * Example 4:
 *
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 *
 *
 */

public class CountingElementsDay7 {

    public static void main(String[] args) {
        int[] inputOne = {1,1,3,3,5,5,7,7};
        System.out.println(countElements(inputOne));
        int[] inputTwo = {1,3,2,3,5,0};
        System.out.println(countElements(inputTwo));
        int[] inputThree = {1,2,3};
        System.out.println(countElements(inputThree));
        int[] inputFour = {1,1,2,2};
        System.out.println(countElements(inputFour));
    }

    private static int countElements(int[] input){
        int result=0;
        Map<Integer,Integer> countMap = new HashMap<>(input.length);
        for (int i : input) {
            if (countMap.containsKey(i)) {
                countMap.put(i, countMap.get(i) + 1);
            } else {
                countMap.put(i, 1);
            }
        }

        for(int i : input){
            if(countMap.containsKey(i+1)){
                result++;
            }
        }
        return result;
    }
}
