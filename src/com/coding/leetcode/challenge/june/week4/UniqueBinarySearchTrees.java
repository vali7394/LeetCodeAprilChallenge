package com.coding.leetcode.challenge.june.week4;/*
  @created 6/24/20
  @Author ** - Meeravali Shaik
 */

public class UniqueBinarySearchTrees {


    public int numTrees(int n) {

        int[] cache = new int[n+1];
        return numTreesRecHelper(n,cache);

       /* if (n <= 1) {
            return 1;
        }
        int[] catalonNo = new int[n + 1];
        catalonNo[0] = catalonNo[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalonNo[i] += catalonNo[j] * catalonNo[i - j - 1];
            }
        }
        return catalonNo[n];*/
    }

    public int numTreesRecHelper(int n, int[] cache) {
        if(n<=1){
            return 1;
        }
        if(cache[n]!=0){
            return cache[n];
        }

        int result = 0;

        for(int i=0; i<=n ; i++){
            result+=numTreesRecHelper(i,cache)*numTreesRecHelper(n-i-1,cache);
        }
        cache[n] = result;
        return cache[n];
    }



}
