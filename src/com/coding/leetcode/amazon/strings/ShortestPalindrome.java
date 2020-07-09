package com.coding.leetcode.amazon.strings;/*
  @created 7/3/20
  @Author ** - Meeravali Shaik
 */

public class ShortestPalindrome {

    public static void main(String[] args) {
        ShortestPalindrome palindrome = new ShortestPalindrome();
        String result = palindrome.shortestPalindrome("abcd");
        System.out.println(result);
    }

    public String shortestPalindrome(String s) {
        if(s==null || s.length()<=1){
            return s;
        }

        String pattern = s+"#"+new StringBuilder(s).reverse();
      int[] lps  = buildLps(pattern);
      StringBuilder builder = new StringBuilder(s.substring(lps[lps.length-1])).reverse();
      builder.append(s);
      return builder.toString();
    }


    public int[] buildLps(String pattern){
        int[] lps = new int[pattern.length()];

        int i=0;
        int j= 1;

        while (j<pattern.length()){
            if(pattern.charAt(i)==pattern.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;
            }else {
                if(i!=0){
                    i = lps[i-1];
                }else {
                    lps[j]=0;
                    j++;
                }
            }
        }
        return lps;
    }

}


/**
 Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

 Example 1:

 Input: "aacecaaa"
 Output: "aaacecaaa"
 Example 2:

 Input: "abcd"
 Output: "dcbabcd"
 **/