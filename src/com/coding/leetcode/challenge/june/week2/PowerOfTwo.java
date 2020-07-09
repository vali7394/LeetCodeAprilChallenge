package com.coding.leetcode.challenge.june.week2;/*
  @created 6/8/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashSet;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        while (n>1){
            if(n%2==0){
                n>>=1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        System.out.println(powerOfTwo.isPowerOfTwo(254));
    }
}

/**
 Given an integer, write a function to determine if it is a power of two.

 Example 1:

 Input: 1
 Output: true
 Explanation: 20 = 1
 Example 2:

 Input: 16
 Output: true
 Explanation: 24 = 16
 Example 3:

 Input: 218
 Output: false
 */