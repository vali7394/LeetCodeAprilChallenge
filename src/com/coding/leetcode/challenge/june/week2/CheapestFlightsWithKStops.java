package com.coding.leetcode.challenge.june.week2;/*
  @created 6/14/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheapestFlightsWithKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        var adjMap = new HashMap<Integer, List<Integer>>();
        int[][] costMatrix = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        for (int[] flight : flights) {

            if (adjMap.containsKey(flight[0])) {
                adjMap.get(flight[0]).add(flight[1]);
            } else {
                List<Integer> destinations = new ArrayList<>();
                destinations.add(flight[1]);
                adjMap.put(flight[0], destinations);
            }
            costMatrix[flight[0]][flight[1]] = flight[2];
        }
        int fare = Integer.MAX_VALUE;
        fare = findCheapestPriceHelper(adjMap, costMatrix, visited, K, src, dst, fare,0);
        if (fare == Integer.MAX_VALUE) {
            return -1;
        }
        return fare;
    }


    public int findCheapestPriceHelper(Map<Integer, List<Integer>> adjMap, int[][] costMatrix,
        boolean[] visited, int k, int source, int destination, int fare, int totalCost) {
        if(k<-1){
            return fare;
        }

        if(source==destination){
            fare = Math.min(fare,totalCost);
            return fare;
        }

        List<Integer> adjNodes = adjMap.get(source);
        if(adjNodes==null){
            return fare;
        }
        visited[source] = true;
        for(int i=0 ; i<adjNodes.size(); i++){
            if(!visited[adjNodes.get(i)] && totalCost + costMatrix[source][adjNodes.get(i)] <=fare){
                fare = findCheapestPriceHelper(adjMap, costMatrix, visited, k - 1, adjNodes.get(i),
                    destination, fare, totalCost + costMatrix[source][adjNodes.get(i)]);
            }
        }
        visited[source] = false;
        return fare;
    }

    public static void main(String[] args) {
        var flightsWithKStops = new CheapestFlightsWithKStops();
        int[][] flights = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
        System.out.println(flightsWithKStops.findCheapestPrice(5, flights, 2, 1, 1));
    }
}


/**

 There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

 Now given all the cities and flights, together with starting city src and the destination dst, your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

 Example 1:
 Input:
 n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 src = 0, dst = 2, k = 1
 Output: 200
 Explanation:
 The graph looks like this:


 The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.
 Example 2:
 Input:
 n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 src = 0, dst = 2, k = 0
 Output: 500
 Explanation:
 The graph looks like this:


 The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.


 Constraints:

 The number of nodes n will be in range [1, 100], with nodes labeled from 0 to n - 1.
 The size of flights will be in range [0, n * (n - 1) / 2].
 The format of each flight will be (src, dst, price).
 The price of each flight will be in the range [1, 10000].
 k is in the range of [0, n - 1].
 There will not be any duplicated flights or self cycles.





 */