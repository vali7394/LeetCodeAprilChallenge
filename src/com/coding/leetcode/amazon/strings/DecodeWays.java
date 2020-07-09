package com.coding.leetcode.amazon.strings;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {


    public static int numDecodings(String s) {
        Map<String,Integer> cache = new HashMap<>();
        System.out.println(noOfWaysToDecodeHelper("314",cache));
        return 0;
    }

    public static void main(String[] s) {
        Map<String,Integer> cache = new HashMap<>();
        numDecodings("314");
    }

    private static int noOfWaysToDecodeHelper(String s, Map<String,Integer> cache){
        if(s.isEmpty() || s.length()==1){
            return 1;
        }

        if(cache.containsKey(s)){
            return cache.get(s);
        }

        int ways = 0;

        if(s.charAt(s.length()-1)>'0') {
            ways+=noOfWaysToDecodeHelper(s.substring(0,s.length()-1),cache);
        }

        if(s.charAt(s.length()-2)=='1' || (s.charAt(s.length()-2)=='2' && s.charAt(s.length()-1)<'7')){
            ways+=noOfWaysToDecodeHelper(s.substring(0,s.length()-2),cache);
        }
        cache.put(s,ways);
        return ways;
    }


}
