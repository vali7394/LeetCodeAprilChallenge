package com.coding.leetcode.amazon.leetcode;/*
  @created 7/8/20
  @Author ** - Meeravali Shaik
 */
import java.util.*;
public class LongSubstringWithoutRepeatingCharacters {


    public int lengthOfLongestSubstring(String s) {

        if(s==null || s.length()==0){
            return 0;
        }

        Map<Character,Integer> tracker = new HashMap<>();
        int i =0;
        int maxLength = 0;
        int start=0;
        while(i<s.length()){
            if(tracker.containsKey(s.charAt(i))){
                start = Math.max(start,tracker.get(s.charAt(i)));
            }
            maxLength = Math.max(maxLength,i-start+1);
            tracker.put(s.charAt(i),i+1);
            i++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        var characters = new LongSubstringWithoutRepeatingCharacters();
        characters.TotalSubstringsWithKDistinct("pqpqs",2);
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s==null || s.length()==0){
            return 0;
        }

        Map<Character,Integer> tracker = new HashMap<>();

        int maxLength =0;
        int start =0;
        int i=0;
        while(i<s.length()){
            tracker.put(s.charAt(i),tracker.getOrDefault(s.charAt(i),0)+1);
            if(tracker.size()>2){
                if(tracker.get(s.charAt(start))==1){
                    tracker.remove(s.charAt(start));
                }else{
                    tracker.put(s.charAt(start),tracker.get(s.charAt(start))-1);
                }
                start++;
            }

            maxLength = Math.max(maxLength,i-start+1);
            i++;
        }
        return maxLength;
    }

    public int subarraysWithKDistinct(int[] A, int K) {
        return 0;
    }

    public int subarraySum(int[] input, int k) {

        if(input==null || input.length==0){
            return 0;
        }
        int start =0, end = 1, sum = input[0], maxLength=0;

        while(end < input.length){
            if(input[end]==k){
                end++;
                continue;
            }
            sum+=input[end];
            if(sum==k){
                maxLength += 1;
            }
            else if (sum < k){
                sum-=input[start];
                start++;
            }
            end++;
        }

        return maxLength;
    }

    public int TotalSubstringsWithKDistinct(String s, int k) {

        if(s==null || s.length()==0 || s.length() < k){
            return 0;
        }


        Map<Character,Integer> tracker = new HashMap<>();
        int start=0, end=0;

        return 0;
    }
}
