package com.coding.leetcode.challenge.May.week1;/*
  @created 5/3/20
  @Author  Meeravali Shaik
 */

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 *
 *
 *
 */

public class RansomNote {

    public static void main(String[] args) {
     //   System.out.println(canConstruct("a","b"));
        System.out.println(canConstruct("aaa","aab"));
   //     System.out.println(canConstruct("aa","aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<String, Long> ransomFreqMap = Arrays.stream(ransomNote.split(""))
            .filter(letter -> !letter.isEmpty())
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> magzineMap = Arrays.stream(magazine.split(""))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for(String key : ransomFreqMap.keySet()){
            if(magzineMap.containsKey(key) && ransomFreqMap.get(key)<=magzineMap.get(key)){
                continue;
            } else {
                return false;
            }
        }
        return true;

    }

}
