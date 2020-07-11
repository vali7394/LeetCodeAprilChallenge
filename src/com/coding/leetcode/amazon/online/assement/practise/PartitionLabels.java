package com.coding.leetcode.amazon.online.assement.practise;/*
  @created 7/10/20
  @Author b008245 - Meeravali Shaik 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {


    public List<Integer> partitionLabels(String S) {

        if(S==null || S.length()==0){
            return Collections.emptyList();
        }

        Map<Character,Integer> freqTracker = new HashMap<>();

        for(int i=0; i<S.length(); i++){
            freqTracker.put(S.charAt(i),i);
        }

        int start=0;
        List<Integer> partions = new ArrayList<>();

        for(int i=0; i<S.length(); i++){
            if(freqTracker.get(S.charAt(i))==i){
                partions.add(i-start+1);
                start = i;
            }
        }
        return partions;
    }
}


/**
 A string S of lowercase English letters is given. We want to partition this string into
 as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.



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
 **/