package com.coding.leetcode.challenge.May.week3;/*
  @created 5/17/20
  @Author - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();
        List<Integer> indices = new ArrayList<>();
        if(sLength<pLength){
            return indices;
        }

        Map<Character,Integer> pMap = new HashMap<>(26);
        for(int i=0; i<pLength;i++){
            if(pMap.containsKey(p.charAt(i))){
                pMap.put(p.charAt(i),pMap.get(p.charAt(i))+1);
            } else {
                pMap.put(p.charAt(i),1);
            }
        }
        Map<Character,Integer> sMap = new HashMap<>(26);
        for(int i=0;i<sLength;i++){
            Character letter = s.charAt(i);
            if(sMap.containsKey(letter)){
                sMap.put(letter,sMap.get(letter)+1);
            }else {
                sMap.put(letter,1);
            }

            if(i>=pLength){
                Character character = s.charAt(i - pLength);
                if (sMap.get(character) == 1) {
                    sMap.remove(character);
                } else {
                    sMap.put(character, sMap.get(character) - 1);
                }

            }
            if(pMap.equals(sMap)){
                indices.add(i-pLength+1);
            }
        }
        return indices;

    }






    public static void main(String[] args) {
        FindAllAnagrams allAnagrams = new FindAllAnagrams();
        System.out.println(allAnagrams.findAnagrams("aa","bb"));
      //  System.out.println(allAnagrams.findAnagrams("abab","ab"));
    }

    public List<Integer> findAnagramsIntuitive(String s, String p) {

        int pLength = p.length();
        int sLength = s.length();
        if(pLength>sLength){
            return Collections.EMPTY_LIST;
        }
        String anaHashCode = computeHashCode(p);
        List<Integer> indices = new ArrayList<>();
        int i = 0;

        while (i<s.length()){
            if((s.length()-i) < p.length()){
                break;
            }
            String subString = s.substring(i,i+p.length());
            String hasCode = computeHashCode(subString);
            if(hasCode.equals(anaHashCode)) indices.add(i);
            i++;
        }
        return indices;
    }

    /*private String computeHashCode(String s){
        System.out.println(String.valueOf(s.hashCode()));
       return String.valueOf(s.hashCode());
    }*/
    private String computeHashCode(String s){
        Map<Character,Integer> charMap = new HashMap<>(26);
        for(int i=0; i<s.length();i++){
            if(charMap.containsKey(s.charAt(i))){
                charMap.put(s.charAt(i),charMap.get(s.charAt(i))+1);
            } else {
                charMap.put(s.charAt(i),1);
            }
        }

        StringBuilder sb = new StringBuilder();
        charMap.entrySet().stream().forEach(entry->sb.append(entry.getKey()+entry.getValue()));
        return sb.toString();
    }
}


/**

 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".


 */