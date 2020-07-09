package com.coding.leetcode.amazon.strings;/*
  @created 7/3/20
  @Author ** - Meeravali Shaik
 */

public class ImplementstrStr {

    public static void main(String[] args) {
        ImplementstrStr str = new ImplementstrStr();
        str.strStr("mississippi","issipi");
    }

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null
            || haystack.length() < needle.length()) {
            return -1;
        }

        if(haystack.isEmpty()|| needle.isEmpty()){
            return 0;
        }

        int[] lps = buildLps(needle);
        var i=0;
        var j=0;
        while (i<haystack.length() && j <needle.length()){

            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
            }else {

                if(lps[j]!=0){
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        if(j==needle.length()){
            return i-j;
        }
        return -1;
    }


    private int[] buildLps(String needle){
     int[] lps = new int[needle.length()];

     var i=0;
     var j=1;

     while (j<needle.length()){

         if(needle.charAt(j)==needle.charAt(i)){
             lps[j] = i+1;
             i++;
             j++;
         } else {
             if(i!=0){
                 i = lps[i-1];
             }else {
                 lps[j] = 0;
                 j++;
             }

         }

     }
     return lps;
    }

    /**

     Implement strStr().

     Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

     Example 1:

     Input: haystack = "hello", needle = "ll"
     Output: 2
     Example 2:

     Input: haystack = "aaaaa", needle = "bba"
     Output: -1
     Clarification:

     What should we return when needle is an empty string? This is a great question to ask during an interview.

     For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().




     */
}
