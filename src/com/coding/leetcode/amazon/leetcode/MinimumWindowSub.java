package com.coding.leetcode.amazon.leetcode;/*
  @created 7/9/20
  @Author b008245 - Meeravali Shaik 
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSub {

    public String minWindow(String s, String t) {
        if(s==null || t==null || s.length() < t.length()){
            return " ";
        }
        if(s.length()==t.length()){
            return s.equals(t)?s:" ";
        }

        Map<Character,Integer> targetMap = new HashMap<>();
        for(char letter : t.toCharArray()){
            targetMap.put(letter,targetMap.getOrDefault(letter,0)+1);
        }

        int start = 0;
        int end=0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int count=targetMap.size();
        while (end<s.length()){
                if(targetMap.containsKey(s.charAt(end)) && targetMap.get(s.charAt(end))>0){
                    count--;
                }
                targetMap.put(s.charAt(end),targetMap.getOrDefault(s.charAt(end),0)-1);
                while (count==0){
                    if(minLength>end-start){
                        minLength = end-start;
                        minStart = start;
                    }
                    char letter = s.charAt(start);
                    targetMap.put(letter,targetMap.get(letter)+1);

                    if(targetMap.get(letter)>0){
                        count++;
                    }
                    start++;

                }
                end++;
        }
        return minLength==Integer.MAX_VALUE?"":s.substring(minStart,minStart+minLength);
    }

    public static void main(String[] args) {
        MinimumWindowSub windowSub = new MinimumWindowSub();
       // windowSub.minWindow("ADOBECODEBANC","ABC");
        System.out.println(windowSub.rob(new int[]{1,2,3,1}));
    }

    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int maxOcurrItem = -1;
        int maxCount = Integer.MIN_VALUE;

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>maxCount){
                maxOcurrItem = entry.getKey();
                maxCount=entry.getValue();
            }
        }

        int startIndex = 0;
        int endIndx = 0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(count==0 && nums[i]==maxOcurrItem){
                startIndex = i;
            }else{
                endIndx= i;
            }
        }
        return endIndx-startIndex+1;
    }


    public int maxProduct(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }


        int maxProduct=Integer.MIN_VALUE;
        int minSoFar = nums[0];
        int maxSoFar = nums[0];

        for(int i : nums){
            int curMax = Math.max(Math.max(maxSoFar*nums[i],minSoFar*nums[i]),nums[i]);
            int curMin = Math.min(Math.min(maxSoFar*nums[i],minSoFar*nums[i]),nums[i]);
            maxProduct = Math.max(maxProduct,curMax);
            maxSoFar = curMax;
            minSoFar = curMin;
        }
        return maxProduct;
    }

    public int rob(int[] nums) {
        return robHelper(0,0,nums);
    }

    public int robHelper(int i,int amount, int[] nums) {
        if(i>=nums.length){
            return amount;
        }
        return Math.max(robHelper(i + 2, amount + nums[i], nums), robHelper(i + 1, amount, nums));
    }
}
