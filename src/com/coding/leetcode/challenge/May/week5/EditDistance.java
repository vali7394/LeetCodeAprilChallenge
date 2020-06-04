package com.coding.leetcode.challenge.May.week5;/*
  @created 5/31/20
  @Author  - Meeravali Shaik
 */

public class EditDistance {


    public int minDistance(String word1, String word2) {

         var m = word1.length();
         var n = word2.length();

         if(m==0){
             return n;
         }

         if(n==0){
             return m;
         }

         int[][] dp = new int[m+1][n+1];

         for(var i =0 ; i<=m; i++){
             for (var j=0; j<=n ; j++){
                 if(i==0){
                     dp[i][j] = i;
                 }
                 else if(j==0){
                     dp[i][j] = j;
                 }
                 else {
                     if (word1.charAt(i-1) == word2.charAt(j-1)) {
                         dp[i][j] = dp[i - 1][j - 1];
                     } else {
                         dp[i][j] =
                             1 + (Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])));
                     }

                 }

             }
         }

         return dp[m][n];

    }
}


/**

 Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

 You have the following 3 operations permitted on a word:

 Insert a character
 Delete a character
 Replace a character
 Example 1:

 Input: word1 = "horse", word2 = "ros"
 Output: 3
 Explanation:
 horse -> rorse (replace 'h' with 'r')
 rorse -> rose (remove 'r')
 rose -> ros (remove 'e')
 Example 2:

 Input: word1 = "intention", word2 = "execution"
 Output: 5
 Explanation:
 intention -> inention (remove 't')
 inention -> enention (replace 'i' with 'e')
 enention -> exention (replace 'n' with 'x')
 exention -> exection (replace 'n' with 'c')
 exection -> execution (insert 'u')

 */