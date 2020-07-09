package com.coding.leetcode.dailycoding.practise;

/*
  @created 5/17/20
  @Author  - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;

public class PermutationString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if(s2Length < s1Length) {
            return false;
        }

        Map<Character,Integer> s1Map = new HashMap<>(26);
        Map<Character,Integer> s2Map = new HashMap<>(26);

        for(int i=0; i<s1Length;i++){
            if(s1Map.containsKey(s1.charAt(i))){
                s1Map.put(s1.charAt(i),s1Map.get(s1.charAt(i))+1);
            } else {
                s1Map.put(s1.charAt(i),1);
            }
        }

        for(int i=0; i<s2Length;i++){
            if(s2Map.containsKey(s2.charAt(i))){
                s2Map.put(s2.charAt(i),s2Map.get(s2.charAt(i))+1);
            } else {
                s2Map.put(s2.charAt(i),1);
            }

            if(i>=s1Length){
                Character character = s2.charAt(i-s1Length);
                if(s2Map.get(character)==1){
                    s2Map.remove(character);
                }else {
                    s2Map.put(character,s2Map.get(character)-1);
                }
            }

            if(s1Map.equals(s2Map)){
                return true;
            }

        }

            return false;
    }
}


/**


 Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.



 Example 1:

 Input: s1 = "ab" s2 = "eidbaooo"
 Output: True
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:

 Input:s1= "ab" s2 = "eidboaoo"
 Output: False

 */