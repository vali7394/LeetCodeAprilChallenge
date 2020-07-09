package com.coding.leetcode.amazon.online.assement;/*
  @created 7/7/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            Collections.emptyList();
        }

        var map = new HashMap<String, List<String>>();

        for (String word : strs) {
            String hashCode = getHashCode(word);
            if (map.containsKey(hashCode)) {
                map.get(hashCode).add(word);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                map.put(hashCode, anagrams);
            }
        }
        return new ArrayList<>(map.values());
    }


    private String getHashCode(String word) {
        int[] count = new int[26];
        for (char letter : word.toCharArray()) {
            count[letter - 'a']++;
        }
        StringBuilder hashCode = new StringBuilder();

        for (int letterCount : count) {
            hashCode.append("#").append(letterCount);
        }
        return hashCode.toString();
    }
}
