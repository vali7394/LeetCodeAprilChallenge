package com.coding.leetcode.amazon.graph;/*
  @created 6/21/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = buildGraph(n,edges);
        Queue<Integer> graphQueue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        graphQueue.offer(0);
        visited[0] = true;
        while (!graphQueue.isEmpty()) {
            int i = graphQueue.poll();
            boolean isValid = isValidTree(graph, visited, i, graphQueue);
            if(!isValid){
                return false;
            }
        }

        for(boolean status : visited){
            if(!status){
                return false;
            }
        }

        return true;

    }

    private static boolean isValidTree(Map<Integer, List<Integer>> graph,boolean[] visited, int i,Queue<Integer> graphQueue){
        for(int j : graph.get(i)){
            if(visited[j]){
                return false;
            }
            graphQueue.offer(j);
            visited[j] = true;
            if(!graph.get(j).isEmpty()){
                int index = graph.get(j).indexOf(i);
                graph.get(j).remove(index);

            }
        }
        return true;
    }



    private Map<Integer, List<Integer>> buildGraph(int n,int[][] edges){
        var graph = new HashMap<Integer, List<Integer>>();
        for(int i=0 ; i<n ; i++){
            graph.put(i,new ArrayList<>());
        }
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }

    public static void main(String[] args) {
        GraphValidTree validTree = new GraphValidTree();
       // int[][] input = new int[][]{{0,1}, {0,2}, {0,3}, {1,4}};
        int[][] input = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        System.out.println(validTree.validTree(5,input));
    }


}


/**
 Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

 Example 1:

 Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 Output: true
 Example 2:

 Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 Output: false
 Note: you can assume that no duplicate edges will appear in edges.
 Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */
