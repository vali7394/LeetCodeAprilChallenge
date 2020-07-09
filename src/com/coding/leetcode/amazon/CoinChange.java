package com.coding.leetcode.amazon;/*
  @created 7/1/20
  @Author ** - Meeravali Shaik
 */

import java.util.Arrays;
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[][] coinChanges = new int[coins.length+1][amount+1];

        for(int i=1; i<=amount;i++){
            coinChanges[0][i] = 0;
        }

        for(int i=0; i<=coins.length; i++){
            coinChanges[i][0] = 1;
        }

        for(int i=1; i<=coins.length; i++){
            for(int j=1; j<=amount; j++){

                if(j>coins[i-1]) {
                    coinChanges[i][j] = coinChanges[i-1][j];
                } else {
                    coinChanges[i][j] = coinChanges[i-1][j] + coinChanges[i][j-coins[i-1]];
                }
            }
        }

        return coinChanges[coinChanges.length][amount];
    }




    public int change(int[] coins, int amount) {
        int[] minCoin = new int[amount+1];
        Arrays.fill(minCoin,Integer.MAX_VALUE);
        minCoin[0] = 0;

        for(int i=1; i<=amount ; i++){
            for(int j=0; i<coins.length; j++){
                if(i<=coins[j]) {
                    minCoin[i] = Math.min(minCoin[i], 1 + minCoin[amount - coins[j]]);
                }
            }
        }
        return minCoin[amount]==Integer.MAX_VALUE?-1:minCoin[amount];
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
 **/