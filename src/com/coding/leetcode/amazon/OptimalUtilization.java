package com.coding.leetcode.amazon;/*
  @created 6/15/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class OptimalUtilization {

    public static void main(String[] args) {
        int[] foreGround = {1, 7, 2, 4, 5, 6};
        int[] backGround = {3,1,2};
        OptimalUtilization utilization = new OptimalUtilization();
        List<int[]> usage = utilization.optimizeMemoryUsage(foreGround,backGround,6);
        System.out.println(usage);
    }

    public List<int[]> optimizeMemoryUsage(int[] foregroundTasks, int[] backgroundTasks, int K) {
        Map<Integer,List<int[]>> optimizationTracker = new TreeMap<>();

        for (int i = 0; i < foregroundTasks.length; i++) {
            for (int j = 0; j < backgroundTasks.length; j++) {
                 if (foregroundTasks[i] + backgroundTasks[j] > K) {
                    int foreDiff = K - foregroundTasks[i];
                    int backDiff = K - backgroundTasks[j];
                    addToTrackerMap(optimizationTracker, i, -1, foreDiff);
                    addToTrackerMap(optimizationTracker, -1, j, backDiff);
                } else if(foregroundTasks[i] + backgroundTasks[j] <= K){
                    int diff = K - (foregroundTasks[i] + backgroundTasks[j]);
                    addToTrackerMap(optimizationTracker, i, backgroundTasks[j],
                        diff);
                }
            }
        }
        return new ArrayList<>(optimizationTracker.values().stream().findFirst().get());
    }

    private void addToTrackerMap(Map<Integer, List<int[]>> tracker, int foreGround, int backGround,
        int key) {
        if (tracker.containsKey(key)) {
            List<int[]> pairs =  tracker.get(key);
            tracker.get(key).add(new int[]{foreGround, backGround});
        } else {
            List<int[]> pairs = new ArrayList<>();
            pairs.add(new int[]{foreGround, backGround});
            tracker.put(key, pairs);
        }
    }

}

/**

 Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible.
 Return a list of ids of selected elements. If no pair is possible, return an empty list.

 Example 1:

 Input:
 a = [[1, 2], [2, 4], [3, 6]]
 b = [[1, 2]]
 target = 7

 Output: [[2, 1]]

 Explanation:
 There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
 Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
 Example 2:

 Input:
 a = [[1, 3], [2, 5], [3, 7], [4, 10]]
 b = [[1, 2], [2, 3], [3, 4], [4, 5]]
 target = 10

 Output: [[2, 4], [3, 2]]

 Explanation:
 There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
 Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
 These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
 Example 3:

 Input:
 a = [[1, 8], [2, 7], [3, 14]]
 b = [[1, 5], [2, 10], [3, 14]]
 target = 20

 Output: [[3, 1]]
 Example 4:

 Input:
 a = [[1, 8], [2, 15], [3, 9]]
 b = [[1, 8], [2, 11], [3, 12]]
 target = 20

 Output: [[1, 3], [3, 2]]

 **/