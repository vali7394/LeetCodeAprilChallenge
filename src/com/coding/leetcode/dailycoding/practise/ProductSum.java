package com.coding.leetcode.dailycoding.practise;/*
  @created 4/4/20
  @Author  - Meeravali Shaik
 */

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at index
 * i of the new array is the product of all the numbers in the original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 *
 *
 *
 */

public class ProductSum {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
      //  productSumWithDivsion(input);
        int[] input1 = {3,2,1};
     //   productSumWithDivsion(input1);

        productSumWithoutDivision(input);
        productSumWithoutDivision(input1);
    }


    // Time Complexity O(n) and Space O(n)
    public static void productSumWithDivsion(int[] input){
        int totalSum = Arrays.stream(input).reduce(1,(a,b)->a*b);
        int[] output = new int[input.length];
        for(int i=0 ; i<input.length;i++) {
            output[i] = totalSum/input[i];
        }
        Arrays.stream(output).forEach(number -> System.out.println("With Division" + number));
    }

    //Time Complexity O(n+n+n) = o(3n) = O(n) space is also same O(3n) = O(n)
    public static void productSumWithoutDivision(int[] input){

        int[] result = new int[input.length];
        int leftSum = 1;
        int[] leftSumResult = new int[input.length];
        leftSumResult[0] = 1;
        for (int i = 1; i < input.length; i++) {
            leftSum = leftSum * input[i - 1];
            leftSumResult[i] = leftSum;
        }
        int rightSum = 1;
        int[] rightSumResult = new int[input.length];
        rightSumResult[input.length - 1] = 1;

        for (int i = input.length - 2; i >= 0; i--) {
            rightSum = rightSum * input[i + 1];
            rightSumResult[i] = rightSum;
        }

        for (int i = 0; i < input.length; i++) {
            result[i] = leftSumResult[i] * rightSumResult[i];
        }

        for (int i : result) {
            System.out.println("Without division" + i);
        }




    }

}
