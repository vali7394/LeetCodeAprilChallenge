package com.coding.leetcode.dailycoding.practise;/*
  @created 4/10/20
  @Author  Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 *  If it does not exist, output -1 for this number.
 *
 *  Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 */
public class NextGreaterElement {

    public static void main(String[] args) {
       int[] nums1 = {4,1,2}; int nums2[] = {1,3,4,2};
        for(int i : nextGreaterElement(nums1,nums2)) {
            System.out.print(i + "  " );
        }

        System.out.println();
        int[] nums3 = {2,4}; int nums4[] = {1,2,3,4};
        for(int i : nextGreaterElement(nums3,nums4)) {
            System.out.print(i + "  " );
        }
    }


    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        while (i < nums2.length) {
            while (!stack.empty() && stack.peek() < nums2[i]) {
                    map.put(stack.pop(), nums2[i]);
                    continue;
                }
                stack.push(nums2[i]);
                i++;
        }

        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

       int[] result = new int[nums1.length];

        for (int j = 0; j < nums1.length; j++) {
            result[j] = map.get(nums1[j]);
        }
        return result;
    }

}
