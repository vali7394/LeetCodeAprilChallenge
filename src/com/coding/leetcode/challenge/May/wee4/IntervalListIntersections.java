package com.coding.leetcode.challenge.May.wee4;/*
  @created 5/23/20
  @Author  - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<>();
        var m = A.length;
        var n = B.length;
        var i=0;
        var j=0;
        while (i<m && j<n){
            if(A[i][0]<=B[j][1] && A[i][1]>=B[j][0]){
                result.add(new int[]{Math.max(A[i][0],B[j][0]),Math.min(A[i][1],B[j][1])});
            }
            if(A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }



}


/**

 Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.

 Return the intersection of these two interval lists.

 (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)

 Example 1:

 Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.


 */