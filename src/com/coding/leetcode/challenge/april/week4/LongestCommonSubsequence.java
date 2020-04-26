package com.coding.leetcode.challenge.april.week4;/*
  @created 4/26/20
  @Author  Meeravali Shaik
 */

import java.util.Arrays;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence.
 *
 * A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.
 *
 *
 *
 * If there is no common subsequence, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * Example 2:
 *
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * Example 3:
 *
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 *
 *
 */

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubSeq("abcde","ace"));
    }

    private static int longestCommonSubSeq(String text1, String text2 ){
        int m = text1.length();
        int n = text2.length();
        int[][] commonPrefixTracker = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    commonPrefixTracker[i][j] = 1 + commonPrefixTracker[i - 1][j - 1];
                } else {
                    commonPrefixTracker[i][j] = Math
                        .max(commonPrefixTracker[i - 1][j], commonPrefixTracker[i][j - 1]);
                }

            }
        }
        return commonPrefixTracker[m][n];
    }


    /*private static String longestCommonSubSeqString(String text1, String text2 ){
        int m = text1.length();
        int n = text2.length();
        int[][] commonPrefixTracker = new int[m+1][n+1];
        StringBuilder result =new StringBuilder();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    commonPrefixTracker[i][j] = 1 + commonPrefixTracker[i - 1][j - 1];
                } else {
                    commonPrefixTracker[i][j] = Math
                        .max(commonPrefixTracker[i - 1][j], commonPrefixTracker[i][j - 1]);
                }

            }
        }

        int i = m;
        int j = n;
       while (i>0 && j>0){

                if(commonPrefixTracker[m][n]!=commonPrefixTracker[m-1][n] && commonPrefixTracker[m][n]!=commonPrefixTracker[m][n-1]){
                   // result.append(t)
                }


            }


    }*/

}
