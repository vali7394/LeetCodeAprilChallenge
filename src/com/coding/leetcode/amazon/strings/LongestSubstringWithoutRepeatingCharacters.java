package com.coding.leetcode.amazon.strings;/*
  @created 6/23/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        var map = new HashMap<Character,Integer>();
        int i=0;
        int j=i+1;
        int maxLength = 1;
        map.put(s.charAt(i),i);
        while (j<s.length()){

            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i,map.get(s.charAt(j)));
            }
            if (maxLength < j-i+1) {
                maxLength = j-i+1;
            }
            map.put(s.charAt(j),j);
            j++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abca"));
    }


}


/**

 Given a string, find the length of the longest substring without repeating characters.

 Example 1:

 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.




 */