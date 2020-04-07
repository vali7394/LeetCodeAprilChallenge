package com.coding.leetcode.dailycoding.practise;/*
  @created 4/7/20
  @Author  Meeravali Shaik
 */

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 */

public class Palindrome {


    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(10));
    }

    private static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        if (n < 10) {
            return true;
        }
        int temp = n;
        int result = 0;

        while (temp > 0) {
            if(result>Integer.MAX_VALUE/10){
                return false;
            }
            result = result*10 + temp % 10;
            temp /= 10;
        }
        return n == result;
    }

    private static boolean isPalindromeHandleOverflow(int n){
        if(n<0 || (n%10==0 && n!=0)){
            return false;
        }
        int revertedNo = 0;
        while(n > revertedNo) {
            revertedNo = revertedNo*10 + n%10;
        }
        return revertedNo==n || n==revertedNo/10;
    }
}
