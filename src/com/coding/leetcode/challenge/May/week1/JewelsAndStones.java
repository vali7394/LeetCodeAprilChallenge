package com.coding.leetcode.challenge.May.week1;/*
  @created 5/2/20
  @Author - Meeravali Shaik
 */

import java.util.HashSet;
import java.util.Set;

/**
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 *
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 *
 * Example 1:
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * Example 2:
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * Note:
 *
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 *
 *
 */
public class JewelsAndStones {

    // Time complexity - O(m+n) Space - O(m) where m = J.length() and n = S.length()
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>(J.length());
        for(Character letter : J.toCharArray()){
            jewels.add(letter);
        }
        int totalJewels = 0;
        for(Character stone : S.toCharArray()) {
            if(jewels.contains(stone)){
                totalJewels++;
            }
        }
        return totalJewels;
    }

}
