package com.coding.leetcode.challenge.april.week1;/*
  @created 4/6/20
  @Author Meeravali Shaik
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.Spring;

/**
 * Given an array of strings, group anagrams together.
 *
 *  Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 */

public class GroupAnagramsDay6 {



    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        sortingApproach(input);
        System.out.println(groupAnagramsHashingTechnique(input));
    }


    // Time complexity O(n*mlogm) - n -> No of words and m-> size of the longest String in the array
    // space - O(nm)
    private static void sortingApproach(String[] words){

        Map<String, List<String>> anagrams = new HashMap<>(words.length);
        // O(n) for loop
        for (String word : words) {

            char[] chars = word.toCharArray();
            // O(mlogm) for sorting - Maximum words in a word
            Arrays.sort(chars);
            String hashKey = new String(chars);

            if (anagrams.containsKey(hashKey)) {
                anagrams.get(hashKey).add(word);
            } else {
                List<String> group = new ArrayList<>();
                group.add(word);
                anagrams.put(hashKey, group);
            }
        }

        List<List<String>> output = new ArrayList<>();
        output.addAll(anagrams.values());

        anagrams.values().stream().forEach(list ->
            {
                System.out.println(" ");
                list.stream().forEach(System.out::print);
            }
        );
    }

    private static List<List<String>> groupAnagramsHashingTechnique(String[] words) {
        Map<String, List<String>> groups = new HashMap<>(words.length);
        for (String word : words) {
            String hashCode = getHashCode(word);
            if (groups.containsKey(hashCode)) {
                groups.get(hashCode).add(word);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(word);
                groups.put(hashCode, anagrams);
            }
        }
        List<List<String>> output = new ArrayList<>();
        output.addAll(groups.values());
        return output;
    }


    private static String getHashCode(String word) {
        int[] countArray = new int[26];
        for (char c : word.toCharArray()) {
            countArray[c - 'a']++;
        }
        StringBuilder hashCode = new StringBuilder();
        for (int s : countArray) {
            hashCode.append("$");
            hashCode.append(s);
        }
        return hashCode.toString();
    }



}
