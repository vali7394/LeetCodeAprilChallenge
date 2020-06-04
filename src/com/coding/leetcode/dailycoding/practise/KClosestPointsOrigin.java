package com.coding.leetcode.dailycoding.practise;/*
  @created 5/22/20
  @Author  - Meeravali Shaik
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {
    public int[][] kClosest(int[][] points, int K) {

        var closetMap = new HashMap<Integer[],Double>(points.length);

        for(int[] input : points){
            Integer[] key = new Integer[] {input[0],input[1]};
           var x = input[0]*input[0];
           var  y = input[1]*input[1];
           var value = Math.sqrt(x+y);
           closetMap.put(key,value);
        }

        var queue = new PriorityQueue<Integer[]>(Comparator.comparing(closetMap::get));

        for(Integer[] input : closetMap.keySet()){
            queue.offer(input);
        }

        int[][] result= new int[K][2];
        var count = 0;
        while (count < K){
            Integer[] output= queue.poll();
            result[count] = new int[]{output[0],output[1]};
            count++;
            }

        return result;
        }
}


/**

 We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

 (Here, the distance between two points on a plane is the Euclidean distance.)

 You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)



 Example 1:

 Input: points = [[1,3],[-2,2]], K = 1
 Output: [[-2,2]]
 Explanation:
 The distance between (1, 3) and the origin is sqrt(10).
 The distance between (-2, 2) and the origin is sqrt(8).
 Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 Example 2:

 Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 Output: [[3,3],[-2,4]]
 (The answer [[-2,4],[3,3]] would also be accepted.)


 */