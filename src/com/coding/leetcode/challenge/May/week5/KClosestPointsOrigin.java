package com.coding.leetcode.challenge.May.week5;/*
  @created 5/30/20
  @Author  - Meeravali Shaik
 */

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {

    public static void main(String[] args) {
            KClosestPointsOrigin closestPointsOrigin = new KClosestPointsOrigin();
            int[][] input  = {{2,2},{2,2},{2,2},{2,2},{2,2},{2,2},{1,1}};
            closestPointsOrigin.kClosest(input,1);
    }


    public int[][] kClosest(int[][] points, int K) {
        var closetMap = new HashMap<int[], Double>(points.length);
        for (int[] point : points) {
            closetMap.put(point, computeDistance(point));
        }
        var queue = new PriorityQueue<int[]>(K,
            (k1, k2) -> closetMap.get(k2).compareTo(closetMap.get(k1)));
        for (int[] point : points) {
            if (queue.size() >= K && computeDistance(queue.peek()) > closetMap.get(point)) {
                queue.poll();
                queue.offer(point);

            } else if(queue.size()<K) {
                queue.offer(point);
            }
        }

        int[][] result = new int[K][];
        var count = K-1;
        while (!queue.isEmpty()) {
            result[count] = queue.poll();
            count--;
        }
        return result;
    }

    private double computeDistance(int[] input) {
        return Math.sqrt(input[0] * input[0] + input[1] * input[1]);
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


 Note:

 1 <= K <= points.length <= 10000
 -10000 < points[i][0] < 10000
 -10000 < points[i][1] < 10000

 */