package com.coding.leetcode.challenge.july;/*
  @created 7/1/20
  @Author ** - Meeravali Shaik
 */

public class ArrangingCoins {

    public int arrangeCoins(int n) {
        return totalWays(n,1);
    }

    private int totalWays(int n , int level){
        if(n==0 || n <level){
            return level-1;
        }
        return totalWays(n-level, level+1);
    }

    public static void main(String[] args) {
        ArrangingCoins coins = new ArrangingCoins();
        System.out.println(coins.arrangeCoins(8));
    }

}


/**
 You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

 Given n, find the total number of full staircase rows that can be formed.

 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:

 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.
 Example 2:

 n = 8

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.
 **/