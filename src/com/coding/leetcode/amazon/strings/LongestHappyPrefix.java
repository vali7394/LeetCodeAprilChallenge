package com.coding.leetcode.amazon.strings;/*
  @created 7/3/20
  @Author ** - Meeravali Shaik
 */

public class LongestHappyPrefix {


    public String longestPrefix(String s) {
     int[] lps = buildLps(s);
     return s.substring(0,lps[lps.length-1]);
    }

    private int[] buildLps(String s){
        int[] lps = new int[s.length()];
        int i=0;
        int j= 1;
        while (j<s.length()){

            if(s.charAt(i)==s.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else {

                if(i==0){
                    lps[j]=0;
                    j++;
                }else {
                    i = lps[i-1];
                }

            }

        }
        return lps;
    }

}

/**
 A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

 Given a string s. Return the longest happy prefix of s .

 Return an empty string if no such prefix exists.



 Example 1:

 Input: s = "level"
 Output: "l"
 Explanation: s contains 4 prefix excluding itself ("l", "le", "lev", "leve"), and suffix ("l", "el", "vel", "evel"). The largest prefix which is also suffix is given by "l".
 Example 2:

 Input: s = "ababab"
 Output: "abab"
 Explanation: "abab" is the largest prefix which is also suffix. They can overlap in the original string.
 Example 3:

 Input: s = "leetcodeleet"
 Output: "leet"
 Example 4:

 Input: s = "a"
 Output: ""


 Constraints:

 1 <= s.length <= 10^5
 s contains only lowercase English letters.
 **/