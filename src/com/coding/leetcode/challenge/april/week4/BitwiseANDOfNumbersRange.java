package com.coding.leetcode.challenge.april.week4;/*
  @created 4/23/20
  @Author    Meeravali Shaik
 */

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 */

public class BitwiseANDOfNumbersRange {


    public static void main(String[] args) {
        System.out.println(bitwiseAnd(1,2));
        System.out.println(bitwiseAnd(2,3));
        System.out.println(bitwiseAnd(9,12));
    }

    private static int bitwiseAnd(int m , int n){
        int result = 0;

        while (m>0 && n>0){
            int mspM = findMsp(m);
            int mspN = findMsp(n);
            if(mspM != mspN){
                return result;
            }
            int mspValue = 1<<mspN;
            result+=mspValue;
            m = m-mspValue;
            n = n-mspValue;

        }
            return result;
    }

    private static int findMsp(int x){
        int mspPosi = -1;
        while (x>0){
            x>>=1;
            mspPosi++;
        }
        return mspPosi;
    }
}
