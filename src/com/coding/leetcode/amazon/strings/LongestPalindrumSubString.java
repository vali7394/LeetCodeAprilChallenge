package com.coding.leetcode.amazon.strings;/*
  @created 6/23/20
  @Author ** - Meeravali Shaik
 */

public class LongestPalindrumSubString {

    public static String longestPalindrome(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        int longPalinSubString = 1;
        int beginIndex = 0;
        for (int i = 1; i < s.length(); i++) {

            int start = i;
            int end = i + 1;

            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                if (longPalinSubString < end - start + 1) {
                    longPalinSubString = end - start + 1;
                    beginIndex = start;
                }
                start--;
                end++;
            }

            start = i - 1;
            end = i + 1;

            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                if (longPalinSubString < end - start + 1) {
                    longPalinSubString = end - start + 1;
                    beginIndex = start;
                }
                start--;
                end++;
            }

        }
        return s.substring(beginIndex, longPalinSubString);
    }

    private static boolean isPalindrum(String input){


        for(int i=0; i<input.length() ; i++){
            if(input.charAt(i)!=input.charAt(input.length()-1)){
                return false;
            }
        }
        return true;
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

 **/