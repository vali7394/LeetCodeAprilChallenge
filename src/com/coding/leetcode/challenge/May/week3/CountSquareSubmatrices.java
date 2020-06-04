package com.coding.leetcode.challenge.May.week3;/*
  @created 5/21/20
  @Author  - Meeravali Shaik
 */

public class CountSquareSubmatrices {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                if (j == 0) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }

                if (matrix[i][j] == 1) {
                    dp[i][j] = 1+ Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        var result = 0;
        for (var i = 0; i < m; i++) {
            for (var j = 0; j < n; j++) {
                result += dp[i][j];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        CountSquareSubmatrices squareSubmatrices = new CountSquareSubmatrices();
        int [][] input = new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}};
        System.out.println(squareSubmatrices.countSquares(input));
    }

}


/**

 Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.



 Example 1:

 Input: matrix =
 [
 [0,1,1,1],
 [1,1,1,1],
 [0,1,1,1]
 ]
 Output: 15
 Explanation:
 There are 10 squares of side 1.
 There are 4 squares of side 2.
 There is  1 square of side 3.
 Total number of squares = 10 + 4 + 1 = 15.
 Example 2:

 Input: matrix =
 [
 [1,0,1],
 [1,1,0],
 [1,1,0]
 ]
 Output: 7
 Explanation:
 There are 6 squares of side 1.
 There is 1 square of side 2.
 Total number of squares = 6 + 1 = 7.



 */

