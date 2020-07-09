package com.coding.leetcode;/*
  @created 7/1/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        var set = new HashSet<String>(wordDict);
        var map = new HashMap<String,Boolean>();
        return doesItExistInDict(s,set,map);
    }


    private boolean doesItExistInDict(String s, Set<String> dict, Map<String, Boolean> cache) {
        if (s.length() == 0) {
            return true;
        }
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        for (int i = 1; i <= s.length(); i++) {
            final var subString = s.substring(i);
            if (dict.contains(s.substring(0, i)) && doesItExistInDict(subString,
                dict, cache)) {
                cache.put(subString, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }


}

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
