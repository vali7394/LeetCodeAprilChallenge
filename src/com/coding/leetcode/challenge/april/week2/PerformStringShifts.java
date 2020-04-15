package com.coding.leetcode.challenge.april.week2;/*
  @created 4/14/20
  @Author Meeravali Shaik
 */

/**
 *  You are given a string s containing lowercase English letters, and a matrix shift, where shift[i] = [direction, amount]:
 *
 * direction can be 0 (for left shift) or 1 (for right shift).
 * amount is the amount by which string s is to be shifted.
 * A left shift by 1 means remove the first character of s and append it to the end.
 * Similarly, a right shift by 1 means remove the last character of s and add it to the beginning.
 * Return the final string after all operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", shift = [[0,1],[1,2]]
 * Output: "cab"
 * Explanation:
 * [0,1] means shift to left by 1. "abc" -> "bca"
 * [1,2] means shift to right by 2. "bca" -> "cab"
 * Example 2:
 *
 * Input: s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
 * Output: "efgabcd"
 * Explanation:
 * [1,1] means shift to right by 1. "abcdefg" -> "gabcdef"
 * [1,1] means shift to right by 1. "gabcdef" -> "fgabcde"
 * [0,2] means shift to left by 2. "fgabcde" -> "abcdefg"
 * [1,3] means shift to right by 3. "abcdefg" -> "efgabcd"
 *
 */
public class PerformStringShifts {


    public static void main(String[] args) {
        String input = "abc";
        int[][] shift = {{0,1},{1,2}};
        System.out.println(shiftedString(input,shift));

        input = "abcdefg";
        int[][] shift1 = {{1,1},{1,1},{0,2},{1,3}};
        System.out.println(shiftedString(input,shift1));
    }

    private static String shiftedString(String input, int[][] shifts) {
        int finalShift = getFinalShift(shifts)%input.length();
        if (finalShift == 0) {
            return input;
        } else if (finalShift < 0) {
            return leftRotate(input, input.length() - Math.abs(finalShift));
        } else {
            return leftRotate(input, finalShift);
        }
    }


    private static int getFinalShift(int[][] shifts) {

        int noOfLeftShits = 0;
        int noOfRightShits = 0;
        int leftWeights = 0;
        int rightWeights = 0;
        for (int[] shift : shifts) {
            if (shift[0] == 0) {
                noOfLeftShits++;
                leftWeights += shift[1];
            } else {
                noOfRightShits++;
                rightWeights += shift[1];
            }
        }
        return leftWeights - rightWeights;
    }

    private static String leftRotate(String s, int left) {
        return s.substring(left) + s.substring(0, left);
    }
}
