package com.coding.leetcode.dailycoding.practise;/*
  @created 5/17/20
  @Author  - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring windowSubstring = new MinimumWindowSubstring();
        windowSubstring.minWindow("ADOBBECODEBBANC","ABBC");
    }

    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character,Integer> subStringMap = new HashMap<>(26);
        for (char c : t.toCharArray()) {
            if (subStringMap.containsKey(c)) {
                subStringMap.put(c, subStringMap.get(c) + 1);
            } else {
                subStringMap.put(c, 1);
            }
        }

        int[] answer = new int[]{-1,0,0};

        int left = 0;
        int right = 0;
        Map<Character,Integer> stringMap = new HashMap<>(26);
        int tracker = 0;
        while (right<s.length()){
            if (stringMap.containsKey(s.charAt(right))) {
                stringMap.put(s.charAt(right), stringMap.get(s.charAt(right) + 1));
            }
            else {
                stringMap.put(s.charAt(right), 1);
            }

            if (subStringMap.containsKey(s.charAt(right))
                && subStringMap.get(s.charAt(right)).intValue() == stringMap.get(s.charAt(right))
                .intValue()) {
                tracker++;
            }

            while (left<=right&&subStringMap.size()==tracker){
               if(answer[0]==-1 || right-left+1 < answer[0]){
                   answer[0] = right-left+1;
                   answer[2] = right;
                   answer[1] = left;
               }
               Character letter = s.charAt(left);
               stringMap.put(letter,stringMap.get(letter)-1);
               if(subStringMap.containsKey(letter) && subStringMap.get(letter).intValue() < stringMap.get(letter).intValue()){
                   tracker--;
               }

                left++;
            }
            right++;
        }

        return answer[0]==-1 ? "":s.substring(answer[1],answer[2]-answer[1]+1);

    }
}


/**

 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 Example:

 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"
 Note:

 If there is no such window in S that covers all characters in T, return the empty string "".
 If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

 */