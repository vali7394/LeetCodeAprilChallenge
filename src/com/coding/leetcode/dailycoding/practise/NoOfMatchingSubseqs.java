package com.coding.leetcode.dailycoding.practise;/*
  @created 6/10/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NoOfMatchingSubseqs {

    public int numMatchingSubseq(String t, String[] words) {
        var countMap = new HashMap<Character, List<Integer>>(26);
        for(var i=0; i<t.length();i++){
            Character letter = t.charAt(i);
            if(countMap.containsKey(letter)){
                countMap.get(letter).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                countMap.put(letter,list);
            }
        }
        int count = 0;
        for(String s : words){
            int low = -1;
            for(var i=0; i<s.length();i++){

                var letter = s.charAt(i);
                if(!countMap.containsKey(letter)){
                    break;
                }
                List<Integer> indices = countMap.get(letter);
                var position = findUpperBound(indices,low);
                if(position==-1){
                    break;
                }
                low = position;
            }
            count++;
        }
        return count;
    }

    private int findUpperBound(List<Integer> indices,int index){
        int low = 0;
        int high = indices.size();
        int result= -1;
        while(low < high){
            int mid = low+(high-low)/2;
            if(indices.get(mid) > index){
                high = mid;
            } else {
                low = mid+1;
            }
            result = low==indices.size()?-1:indices.get(low);
        }
        return result;
    }

}


/**

 Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

 Example :
 Input:
 S = "abcde"
 words = ["a", "bb", "acd", "ace"]
 Output: 3
 Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 Note:

 All words in words and S will only consists of lowercase letters.
 The length of S will be in the range of [1, 50000].
 The length of words will be in the range of [1, 5000].
 The length of words[i] will be in the range of [1, 50].
 */