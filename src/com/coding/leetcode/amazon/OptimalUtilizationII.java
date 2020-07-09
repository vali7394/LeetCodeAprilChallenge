package com.coding.leetcode.amazon;/*
  @created 6/16/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
public class OptimalUtilizationII {

    public List<List<Integer>> findOptimalPairs(int[][] a, int[][] b, int target) {
        TreeMap<Integer, List<List<Integer>>> optimalPairs = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int sum = a[i][1] + b[j][1];
                if (sum <= target) {
                    if (optimalPairs.containsKey(sum)) {
                        optimalPairs.get(sum).add(List.of(a[i][0], b[j][0]));
                    } else {
                        List<List<Integer>> pairs = new ArrayList<>();
                        pairs.add(List.of(a[i][0], b[j][0]));
                        optimalPairs.put(sum, pairs);
                    }

                }

            }

        }
        return optimalPairs.floorEntry(target).getValue();
    }


    public List<List<Integer>> findOptimalPairsSortingTech(int[][] a, int[][] b, int target) {
        Map<Integer, List<List<Integer>>> optimalPairs = new HashMap<>();
        int maxSum = -1;

        for(int i=0; i<a.length; i++){

            for(int j=0; j<b.length; j++){

                int sum = a[i][1] +b[j][1];
                if(sum>target){
                    continue;
                } else if(sum>=maxSum) {
                    if(optimalPairs.containsKey(sum)){
                        optimalPairs.get(sum).add(List.of(a[i][0],b[j][0]));
                    } else {
                        List<List<Integer>> pairs = new ArrayList<>();
                        pairs.add(List.of(a[i][0],b[j][0]));
                        optimalPairs.put(sum,pairs);
                    }
                    maxSum = sum;
                }

            }

        }

        return optimalPairs.get(maxSum);

    }


    public static void main(String[] args) {
        OptimalUtilizationII main = new OptimalUtilizationII();
        int[] maxTravelDists = {7000, 10000, 10000};
        int[][][] forwardRouteLists = {{{1, 2000}, {2, 4000}, {3, 6000}},
            {{1, 2000}, {2, 5000}, {3, 7000}, {4, 10000}},
            {{1, 3000}, {2, 5000}, {3, 7000}, {4, 10000}}};
        int[][][] returnRouteLists = {{{1, 2000}},
            {{1, 2000}, {2, 3000}, {3, 4000}, {4, 5000}},
            {{1, 2000}, {2, 2000}, {3, 4000}, {4, 4000}}};
        for (int i = 0; i < maxTravelDists.length; ++i) {
            System.out.println(main.findOptimalPairsSortingTech(forwardRouteLists[i], returnRouteLists[i],
                maxTravelDists[i]));
        }
    }

}

/**
 *
 * [[2, 1]]
 * [[2, 4], [3, 2]]
 * [[2, 3], [2, 4], [3, 1], [3, 2]]

 Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.

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

 // Amazon | Online Assessment 2019 | Optimal Aircraft Utilization
 // https://leetcode.com/discuss/interview-question/318918/Amazon-or-Online-Assessment-2019-or-Optimal-Aircraft-Utilization

 public class Main {
 public List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
 List<List<Integer>> res = new ArrayList<>();
 int len1 = forwardRouteList.length, len2 = returnRouteList.length;
 if(len1 == 0 || len2 == 0) return res;
 Arrays.sort(forwardRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
 Arrays.sort(returnRouteList, (int[] a, int[] b) -> (a[1] - b[1]));
 int left = 0, right = len2 - 1, maxVal = -1;
 HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
 while(left < len1 && right >= 0){
 int sum = forwardRouteList[left][1] + returnRouteList[right][1];
 if(sum > maxTravelDist){ --right; continue;}
 if(sum >= maxVal){
 int r = right;
 map.putIfAbsent(sum, new ArrayList<>());
 // check the duplicates
 while(r >= 0 && returnRouteList[r][1] == returnRouteList[right][1]){
 List<Integer> list = new ArrayList<>();
 list.add(forwardRouteList[left][0]); list.add(returnRouteList[r][0]);
 map.get(sum).add(list); --r;
 }
 maxVal = sum;
 }
 ++left;
 }
 return map.get(maxVal);
 }
 public static void main(String[] args) {
 Main main = new Main();
 int[] maxTravelDists = {7000, 10000, 10000};
 int[][][] forwardRouteLists ={ {{1, 2000}, {2, 4000}, {3, 6000}},
 {{1, 2000}, {2, 5000}, {3, 7000}, {4, 10000}},
 {{1,3000},{2,5000},{3,7000},{4,10000}}};
 int[][][] returnRouteLists ={ {{1, 2000}},
 {{1, 2000}, {2, 3000}, {3, 4000}, {4, 5000}},
 {{1,2000},{2,2000},{3,4000},{4,4000}}};
 for(int i = 0; i < maxTravelDists.length; ++i){
 System.out.println(main.aircraftUtilization(maxTravelDists[i], forwardRouteLists[i], returnRouteLists[i]));
 }
 }
 }


 */