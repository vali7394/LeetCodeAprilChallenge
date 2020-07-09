package com.coding.leetcode;/*
  @created 6/24/20
  @Author ** - Meeravali Shaik
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        int[] beginInterval = intervals[0];
        int count = 0;
        for(int i=1; i <intervals.length; i++){

            int[] temp = intervals[i];

            if(temp[0] < beginInterval[1]){
                count++;
            } else {
                beginInterval = intervals[i];
            }

        }
        return count;
    }


    public static int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0){
            return 0;
        }
        Arrays.sort(points,Comparator.comparing(point->point[0]));

        int[] startPoint = points[0];
        int arrowCount = 1;
        for(int i=1; i<points.length; i++){
            int[] temp = points[i];
            if(temp[0]>startPoint[1]){
                arrowCount++;
                startPoint = points[i];
            }
        }
        return arrowCount;
    }

    public static void main(String[] args) {
        //int[][] input = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        //findMinArrowShots(input);
        int[] coins = {186,419,83,408};
        coinChange(coins,6249);
    }

    public static int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0){
            return -1;
        }

        if(coins.length==1 && coins[0]>amount){
            return -1;
        }
        Arrays.sort(coins);
        int minCoins = 0;
        int i=coins.length-1;
        while(amount>0 && i>=0){
            while(coins[i]<=amount){
                minCoins++;
                amount-=coins[i];
            }
            i--;
        }
        if(amount>0){
            return -1;
        }
        return minCoins;
    }
}

/**
 Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 Example 1:

 Input: [[1,2],[2,3],[3,4],[1,3]]
 Output: 1
 Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 Example 2:

 Input: [[1,2],[1,2],[1,2]]
 Output: 2
 Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 Example 3:

 Input: [[1,2],[2,3]]
 Output: 0
 Explanation: You don't need to remove any of the intervals since they're already non-overlapping.


 Note:

 You may assume the interval's end point is always bigger than its start point.
 Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 **/