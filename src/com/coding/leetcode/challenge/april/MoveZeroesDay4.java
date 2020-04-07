package com.coding.leetcode.challenge.april;
/*
  @created 4/4/20
  @Author Meeravali Shaik
 */


/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 */

public class MoveZeroesDay4 {

    public static void main(String[] args) {
        int[] input= {0,1,0,3,12};
        for(int i :moveZeros(input)) {
            System.out.println(i);
        }

        for(int i :improvisedMoveZeros(input)) {
            System.out.println(i);
        }

    }


    // Two pointer version of my own
    private static int[] moveZeros(int[] input) {
        int i = 0;
        int right = 0;
        int left = 0;
        while (right<input.length) {
                if(input[right]==0) {
                    right++;
                } else {
                    swap(input, right, left);
                    right++;
                    left++;
                }
        }
        return input;
    }


    private static int[] improvisedMoveZeros(int[] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0) {
                input[count] = input[i];
                count++;
            }
        }
        while (count < input.length) {
            input[count] = 0;
            count++;
        }
        return input;
    }

    private static int[] swap(int[] input,int i , int move){
        int temp = input[i];
        input[i] = input[move];
        input[move] = temp;
        return input;
    }

}
