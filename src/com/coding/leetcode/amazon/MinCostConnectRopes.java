package com.coding.leetcode.amazon;/*
  @created 6/18/20
  @Author ** - Meeravali Shaik
 */

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostConnectRopes {

    private int minCostToConnectRopes(int[] input){
        if(input==null || input.length==0){
            return -1;
        }
        var queue = new PriorityQueue<Integer>();
        for (var rope : input){
            queue.add(rope);
        }
        int sum = 0;
        while (queue.size()>1){
            var first = queue.poll();
            var second = queue.poll();
            int curSum = first+second;
            sum+=curSum;
            queue.add(curSum);
        }
        return sum;
    }

    public static void main(String[] args) {
        MinCostConnectRopes connectRopes = new MinCostConnectRopes();
        int[][] testcases = {{8, 4, 6, 12},
            {20, 4, 8, 2},
            {1, 2, 5, 10, 35, 89},
            {2, 2, 3, 3}};
        System.out.println(connectRopes.minCostToConnectRopes(testcases[0]));
       /* for(int i = 0; i < testcases.length; ++i){
            System.out.println(connectRopes.minCostToConnectRopes(testcases[i]));
        }*/
    }

}

/**
 Given n ropes of different lengths, we need to connect these ropes into one rope. We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of their lengths. The length of this connected rope is also equal to the sum of their lengths.
 This process is repeated until n ropes are connected into a single rope. Find the min possible cost required to connect all ropes.
 Given n ropes of different lengths, we need to connect these ropes into one rope. We can connect only 2 ropes at a time. The cost required to connect 2 ropes is equal to sum of their lengths. The length of this connected rope is also equal to the sum of their lengths. This process is repeated until n ropes are connected into a single rope. Find the min possible cost required to connect all ropes.

 Example 1:

 Input: ropes = [8, 4, 6, 12]
 Output: 58
 Explanation: The optimal way to connect ropes is as follows
 1. Connect the ropes of length 4 and 6 (cost is 10). Ropes after connecting: [8, 10, 12]
 2. Connect the ropes of length 8 and 10 (cost is 18). Ropes after connecting: [18, 12]
 3. Connect the ropes of length 18 and 12 (cost is 30).
 Total cost to connect the ropes is 10 + 18 + 30 = 58
 Example 2:

 Input: ropes = [20, 4, 8, 2]
 Output: 54
 Example 3:

 Input: ropes = [1, 2, 5, 10, 35, 89]
 Output: 224
 Example 4:

 Input: ropes = [2, 2, 3, 3]
 Output: 20

 */