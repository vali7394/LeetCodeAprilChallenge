package com.coding.leetcode.challenge.May.wee4;/*
  @created 5/22/20
  @Author  - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class SortCharactersByFrequency {

    public String frequencySortInitutive(String s) {
        Comparator<Entry<String,String>> valueComparator = ((e1,e2) ->{
            if(e2.getValue().length()-e1.getValue().length()==0){
                 if(e2.getKey().equals(e1.getKey())){
                     return 0;
                 }else {
                     return 1;
                 }
            }
            return e2.getValue().length()-e1.getValue().length();
        });
        Map<String,String> sortByCharFreq = new HashMap<>();
        for(Character character : s.toCharArray()){
            String letter = String.valueOf(character);
            if (sortByCharFreq.containsKey(letter)){
                sortByCharFreq.put(letter,sortByCharFreq.get(letter)+letter);
            }else {
                sortByCharFreq.put(letter,letter);
            }
        }

        StringBuilder builder = new StringBuilder(s.length());
        Set<Map.Entry<String,String>> entryList = new TreeSet<>(valueComparator);
        entryList.addAll(sortByCharFreq.entrySet());
        entryList.stream().forEach(entry -> builder.append(entry.getValue()));
        return builder.toString();
    }

    public static void main(String[] args) {
        SortCharactersByFrequency byFrequency = new SortCharactersByFrequency();
      System.out.println(byFrequency.frequencySort("tree"));
       System.out.println(byFrequency.frequencySort("cccaaa"));
        System.out.println(byFrequency.frequencySort("Aabb"));
    }

    public String frequencySort(String s){
       var charMap = new HashMap<Character,Integer>();
       for(var letter : s.toCharArray()){
           charMap.put(letter,charMap.getOrDefault(letter,0)+1);
       }

        int maximumFrequency = Collections.max(charMap.values());
       System.out.println(maximumFrequency);
        List<Character> characters = new ArrayList<>(charMap.keySet());
        Collections.sort(characters,(c1,c2)->charMap.get(c2)-charMap.get(c1));
        StringBuilder builder = new StringBuilder(s.length());
        for(Character ch : characters){
            var count = charMap.get(ch);
            while (count>0){
                builder.append(ch);
                count--;
            }
        }
            return builder.toString();
    }

}


/**
 Given a string, sort it in decreasing order based on the frequency of characters.

 Example 1:

 Input:
 "tree"

 Output:
 "eert"

 Explanation:
 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 Example 2:

 Input:
 "cccaaa"

 Output:
 "cccaaa"

 Explanation:
 Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 Note that "cacaca" is incorrect, as the same characters must be together.
 Example 3:

 Input:
 "Aabb"

 Output:
 "bbAa"

 Explanation:
 "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.






 */