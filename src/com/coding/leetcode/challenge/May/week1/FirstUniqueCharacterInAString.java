package com.coding.leetcode.challenge.May.week1;/*
  @created 5/5/20
  @Author  - Meeravali Shaik
 */

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 *
 * Note: You may assume the string contain only lowercase letters.
 *
 */
public class FirstUniqueCharacterInAString {

    // TC - O(n+n) = O(2n) =O(n)  Space = O(n)
    public int firstUniqChar(String s) {
        if(s==null || s.length()==0 || s.isEmpty()){
            return -1;
        }
        Map<Character,Integer> tracker = new LinkedHashMap();
        for(int i=0 ; i<s.length();i++){
            if(tracker.containsKey(s.charAt(i))){
                tracker.put(s.charAt(i),-1);
            }else {
                tracker.put(s.charAt(i),i);
            }
        }

        for(Map.Entry<Character,Integer> entry : tracker.entrySet()){
            if(entry.getValue()!=-1){
                return entry.getValue();
            }
        }
        return -1;

    }

    // TC - O(n+n) - O(1) and space - O(1)
    public int firstUniqueBest(String s){

        int result = Integer.MAX_VALUE;
        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);
            if (index != -1 && index == s.lastIndexOf(c)) {
                result = Math.min(result,index);
            }

        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}
