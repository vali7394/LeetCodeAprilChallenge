package com.coding.leetcode.amazon;/*
  @created 6/16/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class TopKFrequentlyMentionedKeywords {

    public static void main(String[] args) {
        int k1 = 2;
        String[] keywords1 = { "anacell", "cetracular", "betacellular" };
        String[] reviews1 = { "Anacell provides the best services in the city", "betacellular has awesome services",
            "Best services provided by anacell, everyone should use anacell", };
        int k2 = 2;
        String[] keywords2 = { "anacell", "betacellular", "cetracular", "deltacellular", "eurocell" };
        String[] reviews2 = { "I love anacell Best services; Best services provided by anacell",
            "betacellular has great services", "deltacellular provides much better services than betacellular",
            "cetracular is worse than anacell", "Betacellular is better than deltacellular.", };
        System.out.println(solve(k1, keywords1, reviews1));
        System.out.println(solve(k2, keywords2, reviews2));
    }


    private static List<String> solve(int k, String[] keywords, String[] reviews) {
        Set<String> keyWordSet = new HashSet<>();
        for(String key : keywords) {
            keyWordSet.add(key.toLowerCase());
        }
        Map<String,Integer> occurances = new HashMap<>();
        for(String review : reviews){
            String[] list = review.split(" ");
            for(String word : list) {
                if (keyWordSet.contains(word.toLowerCase())) {
                    if (occurances.containsKey(word.toLowerCase())) {
                        occurances.put(word, occurances.get(word.toLowerCase()) + 1);
                    } else {
                        occurances.put(word.toLowerCase(), 1);
                    }
                }
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue() == e2.getValue()) {
                return e1.getKey().compareTo(e2.getKey());
            } else {
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        queue.addAll(occurances.entrySet());
        List<String> freqWords = new ArrayList<>();
        while (!queue.isEmpty() && k>0){
            freqWords.add(queue.poll().getKey());
            k--;
        }
        return freqWords;
    }
}





/**
 Given a list of reviews, a list of keywords and an integer k. Find the most popular k keywords in order of most to least frequently mentioned.

 The comparison of strings is case-insensitive.
 Multiple occurances of a keyword in a review should be considred as a single mention.
 If keywords are mentioned an equal number of times in reviews, sort alphabetically.

 Example 1:

 Input:
 k = 2
 keywords = ["anacell", "cetracular", "betacellular"]
 reviews = [
 "Anacell provides the best services in the city",
 "betacellular has awesome services",
 "Best services provided by anacell, everyone should use anacell",
 ]

 Output:
 ["anacell", "betacellular"]

 Explanation:
 "anacell" is occuring in 2 different reviews and "betacellular" is only occuring in 1 review.
 Example 2:

 Input:
 k = 2
 keywords = ["anacell", "betacellular", "cetracular", "deltacellular", "eurocell"]
 reviews = [
 "I love anacell Best services; Best services provided by anacell",
 "betacellular has great services",
 "deltacellular provides much better services than betacellular",
 "cetracular is worse than anacell",
 "Betacellular is better than deltacellular.",
 ]

 Output:
 ["betacellular", "anacell"]

 Explanation:
 "betacellular" is occuring in 3 different reviews. "anacell" and "deltacellular" are occuring in 2 reviews, but "anacell" is lexicographically smaller.
 **/