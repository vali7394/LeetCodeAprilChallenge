package com.coding.leetcode.challenge.june.week1;/*
  @created 6/7/20
  @Author ** - Meeravali Shaik
 */

public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int j = 0; j < dp.length; j++) {
            dp[j][0] = 1;
        }

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (j < coins[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i - 1][j];
                }

            }
        }
        return dp[coins.length][amount];
    }

}


/**
 You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.



 Example 1:

 Input: amount = 5, coins = [1, 2, 5]
 Output: 4
 Explanation: there are four ways to make up the amount:
 5=5
 5=2+2+1
 5=2+1+1+1
 5=1+1+1+1+1
 Example 2:

 Input: amount = 3, coins = [2]
 Output: 0
 Explanation: the amount of 3 cannot be made up just with coins of 2.
 Example 3:

 Input: amount = 10, coins = [10]
 Output: 1


 Note:

 You can assume that

 0 <= amount <= 5000
 1 <= coin <= 5000
 the number of coins is less than 500
 the answer is guaranteed to fit into signed 32-bit integer

 */