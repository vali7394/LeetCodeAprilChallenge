package com.coding.leetcode.challenge.april.week1;/*
  @created 4/5/20
  @Author  Meeravali Shaik
 */

/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 *  Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 *
 */
public class BestTimeBuySellStockDay5 {

    public static void main(String[] args) {

        int[] input= {6,1,3,2,4,7};
        System.out.println(maxProfit(input));
        int[] input1 = {1, 2, 3, 4, 5};
        System.out.println(maxProfit(input1));
        int[] input2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(input2));
        int[] input3 = {100, 80, 120, 130, 70,60,100,125};
        System.out.println(maxProfit(input3));
    }

    private static int maxProfit(int[] input){
        int maxProfit=0;
        for(int i=1;i<input.length-1;i++){
            int currentProfit = input[i]-input[i-1];
            if(currentProfit>0){
                maxProfit += currentProfit;
            }
        }
        return maxProfit;
    }

    private static int buySellOneTran(int[] input){
        int minBuyPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < input.length; i++) {
            minBuyPrice = Math.min(minBuyPrice, input[i]);
            profit = Math.max(profit, input[i] - minBuyPrice);
        }
        return profit;
    }


}
