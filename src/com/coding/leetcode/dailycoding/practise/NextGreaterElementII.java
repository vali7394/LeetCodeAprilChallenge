package com.coding.leetcode.dailycoding.practise;/*
  @created 4/11/20
  @Author  Meeravali Shaik
 */

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular array (the next element of the last element is the first element of the array),
 * print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number
 * to its traversing-order next in the array, which means you could search circularly to find its next greater number.
 *  If it doesn't exist, output -1 for this number.
 *
 *   Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 *
 */



public class NextGreaterElementII {

    public static void main(String[] args) {
        int[] input = {1,2,1};
        for(int i : nextGreaterElement(input)) {
            System.out.println(i);
        }
    }

    private static int[] nextGreaterElement(int[] input){
        int n = input.length;
        Stack<Integer> tracker = new Stack<>();
        int[] result = new int[input.length];
        Arrays.fill(result,-1);

        for(int i=0 ;i<2*n;i++) {
            while (!tracker.isEmpty() && input[tracker.peek()] < input[i%n]){
                result[tracker.pop()] = input[i%n];
            }
            if(i<n){
                tracker.push(i);
            }
        }
        return result;

    }


}
