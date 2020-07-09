package com.coding.leetcode.challenge.june.week3;/*
  @created 6/20/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    private void getNextPerm(int n, int k, int[] factorial, List<Integer> digits,
        StringBuilder permResult) {
        if (n == 1) {
            permResult.append(digits.get(0));
            return;
        }
        int index = k / factorial[n - 1];

        if (k % factorial[n - 1] == 0) {
            index = index - 1;
        }

        permResult.append(digits.get(index));
        digits.remove(index);
        int newK = k - (factorial[n - 1] * index);
        getNextPerm(n - 1, newK, factorial, digits, permResult);
    }


    public String getPermutation(int n, int k) {
        int[] factorial = new int[n];
        List<Integer> digits = new ArrayList<>();

        int f=1;
        factorial[0] = 1;
        for(int i=1; i<n ; i++){
            factorial[i] = factorial[i - 1] * i;
        }

        for(int i=1; i<=n ; i++){
            digits.add(i);
        }
        StringBuilder result = new StringBuilder();
        getNextPerm(n, k, factorial, digits, result);
        return result.toString();
    }


    public static void main(String[] args) {
        PermutationSequence sequence = new PermutationSequence();
        System.out.println(sequence.getPermutation(4,14));
    }
}

/**

 The set [1,2,3,...,n] contains a total of n! unique permutations.

 By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 Given n and k, return the kth permutation sequence.

 Note:

 Given n will be between 1 and 9 inclusive.
 Given k will be between 1 and n! inclusive.
 Example 1:

 Input: n = 3, k = 3
 Output: "213"
 Example 2:

 Input: n = 4, k = 9
 Output: "2314"





 */