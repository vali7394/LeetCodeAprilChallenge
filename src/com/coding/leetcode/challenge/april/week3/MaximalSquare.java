package com.coding.leetcode.challenge.april.week3;/*
  @created 4/27/20
  @Author  Meeravali Shaik
 */

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 *
 */
public class MaximalSquare {

    public static void main(String[] args) {
        char[][] input = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(maximalSquare(input));
    }

    private static int maximalSquare(char[][] matrix){
        int largest = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        for(int i=1; i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j] = 1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
                }
                largest = Math.max(largest,dp[i][j]);
            }
        }


        return largest*largest;
    }

}
