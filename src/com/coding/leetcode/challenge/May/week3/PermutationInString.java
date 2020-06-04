package com.coding.leetcode.challenge.May.week3;/*
  @created 5/18/20
  @Author  - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();
        if(s2Length < s1Length){
            return false;
        }

        Map<Character,Integer> s1Map = new HashMap<>(26);
        for(int i=0 ; i<s1.length();i++){
            Character letter = s1.charAt(i);
            if(s1Map.containsKey(letter)){
                s1Map.put(letter,s1Map.get(letter)+1);
            }else {
                s1Map.put(letter,1);
            }
        }

        Map<Character,Integer> s2Map = new HashMap<>(26);
        for(int i=0; i<s2Length;i++){
            Character letter = s2.charAt(i);
            if(s2Map.containsKey(letter)){
                s2Map.put(letter,s2Map.get(letter)+1);
            }else {
                s2Map.put(letter,1);
            }

            if(i>=s1Length){
                int pos = i-s1Length;
                Character character = s2.charAt(pos);
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


    public static void main(String[] args){
        PermutationInString permutationInString = new PermutationInString();
        System.out.println(permutationInString.checkInclusion("ab","eidbaooo"));
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


 Note:

 The input strings only contain lower case letters.
 The length of both given strings is in range [1, 10,000].


 */