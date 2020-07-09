package com.coding.leetcode.amazon;

/*
  @created 6/18/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {


    public List<Integer> partitionLabels(String S) {

        Map<Character,Integer> charMap  = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char letter = S.charAt(i);
                charMap.put(letter, i);
            }

        List<Integer> result= new ArrayList<>();

        int i=0;

        while (i<S.length()){
            int end = charMap.get(S.charAt(i));
            int j = i+1;

            while (j!=end){
                end = Math.max(end, charMap.get(S.charAt(j)));
                j++;
            }
            result.add(j-i+1);
            i=j+1;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels labels = new PartitionLabels();
        System.out.println(labels.partitionLabels(s));
    }
}


/**
 A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.



 Example 1:

 Input: S = "ababcbacadefegdehijhklij"
 Output: [9,7,8]
 Explanation:
 The partition is "ababcbaca", "defegde", "hijhklij".
 This is a partition so that each letter appears in at most one part.
 A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.


 Note:

 S will have length in range [1, 500].
 S will consist of lowercase English letters ('a' to 'z') only.
 */