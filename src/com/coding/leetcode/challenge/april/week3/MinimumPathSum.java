package com.coding.leetcode.challenge.april.week3;/*
  @created 4/18/20
  @Author - Meeravali Shaik
 */

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 *
 *
 *
 */

public class MinimumPathSum {


    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,3,5},{2,3,2},{4,3,1}}));
    }


    // dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]
    private static int minPathSum(int[][] input){

        int m = input.length;
        int n = input[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = input[0][0];

        for(int i=1; i<n;i++){
            dp[0][i] = input[0][i]+dp[0][i-1];
        }

        for(int i=1 ; i<m;i++){
            dp[i][0] = input[i][0]+dp[i-1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = input[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m-1][n-1];
    }

}
