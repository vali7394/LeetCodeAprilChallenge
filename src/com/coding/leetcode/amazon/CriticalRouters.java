package com.coding.leetcode.amazon;/*
  @created 6/16/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CriticalRouters {

    public int[] findArticulationPoint(int n, int e, int[][] edges){
        if(edges==null || edges.length==0){
            return new int[]{};
        }
        Map<Integer, List<Integer>> graph = buildGraph(n,edges);

        Set<Integer> visited = new HashSet<>();
        Set<Integer> criticalPoints = new HashSet<>();
        Map<Integer,Integer> lowTime = new HashMap<>();
        Map<Integer,Integer> visitedTime = new HashMap<>();





    return null;

    }


    private void findCriticalDfs(Map<Integer, List<Integer>> graph, int parent,int node,
        Set<Integer> visited, Set<Integer> criticalPoints, Map<Integer, Integer> lowTime,
        Map<Integer, Integer> visitedTime) {
        visited.add(node);
        //lowTime.put(node,lowTime+1);


    }


    private Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        var map = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            map.getOrDefault(edge[0], new ArrayList<>());
            map.getOrDefault(edge[1], new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return map;
    }

}

/**

 You are given an undirected connected graph. An articulation point (or cut vertex) is defined as a vertex which, when removed along with associated edges, makes the graph disconnected (or more precisely, increases the number of connected components in the graph). The task is to find all articulation points in the given graph.

 Input:
 The input to the function/method consists of three arguments:

 numNodes, an integer representing the number of nodes in the graph.
 numEdges, an integer representing the number of edges in the graph.
 edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
 Output:
 Return a list of integers representing the critical nodes.

 Example:

 Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]

 **/