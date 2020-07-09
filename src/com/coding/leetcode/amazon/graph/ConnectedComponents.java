package com.coding.leetcode.amazon.graph;/*
  @created 6/21/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConnectedComponents {

    public int countComponentsBFS(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Queue<Integer> nodes = new LinkedList<>();
        int components = 0;
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        for(Integer key : graph.keySet()){
            if(!visited[key]){
                nodes.add(key);
                visited[key] = true;
                markConnectedComponents(graph,visited,nodes);
                components++;
            }
        }
        return components;
    }

    private void markConnectedComponents(Map<Integer, List<Integer>> graph,boolean[] visited,Queue<Integer> nodes){
        if(nodes.isEmpty()){
            return ;
        }
        int parent = nodes.poll();
        List<Integer> childs = graph.get(parent);
        if(childs!=null){
            for(int i : childs){
                if(!visited[i]){
                    visited[i] = true;
                    nodes.offer(i);
                    markConnectedComponents(graph,visited,nodes);
                }
            }
        }
    }

    private Map<Integer, List<Integer>> buildGraph(int[][] edges){
        return Stream.of(edges).collect(Collectors.groupingBy(result -> result[0],
            Collectors.mapping(result -> result[1], Collectors.toList())));
    }

    private Map<Integer, List<Integer>> buildGraphExample(int n, int[][] edges){
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for(int i=0; i<n ; i++){
            adjMap.put(i,new ArrayList<>());
        }
        for(int[] edge : edges){
            adjMap.get(edge[0]).add(edge[1]);
        }
        return adjMap;
    }

    public int countComponents(int n, int[][] edges) {
        if(n<=1){
            return n;
        }
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> adjMap = buildGraphExample(n,edges);
        int compoCoun = 0;
        for(int i=0; i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                compoCoun+=markComponent(adjMap,visited,i);
            }
        }
        return compoCoun;
    }

    private int markComponent(Map<Integer, List<Integer>> adjMap, boolean[] visited, int i) {
        for(int j : adjMap.get(i)){
            if(!visited[j]){
                visited[j] = true;
                markComponent(adjMap,visited,j);
            }
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        ConnectedComponents components = new ConnectedComponents();
      //int[][] input = {{0,1}, {1, 2}, {3, 4}};
        int[][] input = {{1,0}};
        System.out.println(components.countComponents(2,input));
    }
}


/**
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

 Example 1:

 Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

 0          3
 |          |
 1 --- 2    4

 Output: 2
 Example 2:

 Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

 0           4
 |           |
 1 --- 2 --- 3

 Output:  1
 Note:
 You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

 **/