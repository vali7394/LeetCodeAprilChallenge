package com.coding.leetcode.amazon.graph;/*
  @created 6/20/20
  @Author ** - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Arrays;

public class ShortestPathFlight {


    public static void main(String[] args) {
        int[][] flights = {{4,1},{4,0},{0,4},{0,3},{1,3},{1,2},{1,4}};
       // shortestPathFromSourceToDest(4,flights,4,3);
        dfsApproach(4,flights);
    }


    private static void shortestPathFromSourceToDest(int n ,int[][] flights, int source, int dest){

        Map<Integer,List<Integer>> graph = buildGraph(flights);
        int[] visited = new int[n+1];
        int[] parent = new int[n+1];
        Arrays.fill(parent,-1);
        Arrays.fill(visited,-1);
        Queue<Integer> queue = new LinkedList<>();
        visited[source]=0;
        queue.offer(source);
        visitEachNode(graph,queue,visited,parent);
        for(int i=1 ; i<visited.length ; i++){
            if(i==-1){
                System.out.println("Not Visited");
            }else {
                System.out.printf("Level of Node {%d} {%d}", i,visited[i]);
                System.out.println();
            }
        }

        for(int i =0 ; i<=n ; i++){
            System.out.printf("each parent {%d} {%d}",i,parent[i]);
            System.out.println();
        }



    }


    private static void visitEachNode(Map<Integer,List<Integer>> graph,
        Queue<Integer> nodeQueue,int[] visited , int[] parent){
        if(nodeQueue.isEmpty()){
            return;
        }
        int source = nodeQueue.poll();
        List<Integer> neighBours = graph.get(source);
        if(neighBours!=null) {
            for(int node : neighBours){
                if(visited[node]==-1) {
                    visited[node] = visited[source]+1;
                    parent[node] = source;
                    nodeQueue.offer(node);
                    visitEachNode(graph, nodeQueue, visited, parent);
                }
                }
            }

        }

    private static Map<Integer,List<Integer>> buildGraph(int[][] flights) {
        return Stream.of(flights).collect(Collectors.groupingBy(flight -> flight[0],
            Collectors.mapping(flight -> flight[1], Collectors.toList())));
    }



    private static void dfsApproach(int n, int[][] flights){
        Map<Integer,List<Integer>> graph = buildGraph(flights);
        int[] pre = new int[n+1];
        int[] post = new int[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(pre,-1);
        dfs(graph,4,pre,post,0,visited);
        for (int i : pre){
            System.out.println(i);
        }
        for (int i : post){
            System.out.println(i);
        }
    }

    private static void dfs(Map<Integer,List<Integer>> graph, int i , int[] pre , int[] post , int count, boolean[] visited){
        if(visited[i]){
            return ;
        }
        pre[i] = count;
        count++;
        visited[i] = true;
        if(graph.containsKey(i)) {
            for (int j : graph.get(i)) {
                dfs(graph, j, pre, post, count, visited);
                post[i] = count;
                count++;
            }
        }
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