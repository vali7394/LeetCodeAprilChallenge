package com.coding.leetcode.dailycoding.practise;/*
  @created 6/8/20
  @Author ** - Meeravali Shaik
 */

public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int n = s.length();
        if(n==1){
            return s;
        }
        int start = 0;
        int end = 0;
        String result = "";
        if(n%2==0){
            int midRight = n/2;
            int midLeft = midRight-1;

            while (midRight < n && midLeft >= 0 && s.charAt(midLeft) == s.charAt(midRight)) {
                    start = midLeft;
                    end = midRight;
                    midLeft--;
                    midRight++;
                    if(result.length() < end-start+1){
                        result =  s.substring(midLeft,Math.min(n,midRight+1));
                    }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}


/**
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */