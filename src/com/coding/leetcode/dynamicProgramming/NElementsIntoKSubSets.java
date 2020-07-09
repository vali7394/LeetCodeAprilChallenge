package com.coding.leetcode.dynamicProgramming;/*
  @created 6/29/20
  @Author ** - Meeravali Shaik
 */

public class NElementsIntoKSubSets {

    public int getWaysToPartitionNIntoK(int n, int k,int[][] cache){
        if(k > n){
            return 0;
        }
        if(k==1 || k==n){
            return 1;
        }
        if(cache[n][k]!=0){
            return cache[n][k];
        }
        cache[n][k] =
            k * getWaysToPartitionNIntoK(n - 1, k, cache) + getWaysToPartitionNIntoK(n - 1, k - 1,
                cache);
        return cache[n][k];
    }

    public static void main(String[] args) {
        int[][] cache = new int[5][3];
        NElementsIntoKSubSets kSubSets = new NElementsIntoKSubSets();
        System.out.println(kSubSets.getWaysToPartitionNIntoK(4,2,cache));
        kSubSets.getPartitionsDp(4,2);
    }

    public void getPartitionsDp(int n, int k){
        int[][] dp = new int[n+1][k+1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= k; i++)
            dp[0][k] = 0;

        for(int i=1; i<=n;i++){
            for(int j=1; j<=i && j<=k; j++){

                if(j==1 || j==i){
                    dp[i][j]=1;
                } else {
                    dp[i][j] = j*dp[i-1][j]+dp[i-1][j-1];
                }
            }
        }
        System.out.println(dp[n][k]);
    }

}


