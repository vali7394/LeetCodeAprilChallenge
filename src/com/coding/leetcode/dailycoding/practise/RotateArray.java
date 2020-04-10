package com.coding.leetcode.dailycoding.practise;/*
  @created 4/8/20
  @Author - Meeravali Shaik
 */

/**
 * Given an array and a number k that's smaller than the length of the array, rotate the array to the right k elements in-place.
 *  Input: [1,2,3,4,5,6,7] and k = 3
 *  Output: [5,6,7,1,2,3,4]
 *
 *  Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 */

public class RotateArray {

    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        int k=2;
        reverseArray(input,0,input.length-1);
        reverseArray(input,0,k-1);
        reverseArray(input,k,input.length-1);
        for(int i : input){
            System.out.print(i);
        }

    }


    private static void reverseArray(int[] input, int start,int end){
        while (start<end){
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

}
