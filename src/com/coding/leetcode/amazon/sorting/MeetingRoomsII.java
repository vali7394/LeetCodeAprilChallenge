package com.coding.leetcode.amazon.sorting;/*
  @created 6/26/20
  @Author ** - Meeravali Shaik
 */
import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoomsII {


    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0){

        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int i=0;
        for(int[] input : intervals){
            start[i] = input[0];
            end[i] = input[1];
            i++;
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int meetingRooms = 0;
        int pre =0;
       for(int j=0; j<intervals.length;j++){
            meetingRooms++;
            if(start[j]>=end[pre]){
                meetingRooms--;
                pre++;
            }
        }
       return meetingRooms;
    }
}


/**
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

 Example 1:

 Input: [[0, 30],[5, 10],[15, 20]]
 Output: 2
 Example 2:

 Input: [[7,10],[2,4]]
 Output: 1
 NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 **/