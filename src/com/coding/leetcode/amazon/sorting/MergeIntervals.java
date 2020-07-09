package com.coding.leetcode.amazon.sorting;/*
  @created 6/26/20
  @Author ** - Meeravali Shaik
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparing(i1 -> i1[0]));
        List<int[]> result = new ArrayList<>();
        int[] curInterval = intervals[0];
        result.add(curInterval);
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = intervals[i];
            if (temp[0] <= curInterval[1]) {
                curInterval[1] = Math.max(curInterval[1], temp[1]);
            } else {
                result.add(temp);
                curInterval = temp;
            }

        }
        int[][] merged = new int[result.size()][];
        return result.toArray(merged);
    }

    public static void main(String[] args) {
        MergeIntervals intervals = new MergeIntervals();
        intervals.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
    }


}


/**
 Given a collection of intervals, merge all overlapping intervals.

 Example 1:

 Input: [[1,3],[2,6],[8,10],[15,18]]
 Output: [[1,6],[8,10],[15,18]]
 Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 Example 2:

 Input: [[1,4],[4,5]]
 Output: [[1,5]]
 Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 **/