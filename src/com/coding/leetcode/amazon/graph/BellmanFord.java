package com.coding.leetcode.amazon.graph;/*
  @created 6/24/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
public class BellmanFord {


    public static void main(String[] args){
        int[][] edges = new int[][]{{3,2,-10},{4,3,3},{1,4,5},{1,2,4}};
        BellmanFord bellmanFord = new BellmanFord();
        bellmanFord.shortestPathToAll(4,edges);


    }

    private void shortestPathToAll(int n , int[][] edges){
        int[] distance = new int[n+1];
        Arrays.fill(distance,30);
       // var graph = buildGraph(edges);
        distance[1] = 0;
        for(int i=1; i<n ; i++){
            for(int[] edge : edges){
                if(distance[edge[1]]>distance[edge[0]]+edge[2]){
                    distance[edge[1]] = distance[edge[0]]+edge[2];
                }
            }

        }

        for(int i=1;i<distance.length ;i++){
            System.out.println("Distance to" + i + " Is " + distance[i]);
        }

    }

    private Map<Integer, List<Edge>> buildGraph(int[][] edges){

        var map = new HashMap<Integer, List<Edge>>();

        for(int[] edge : edges){
            if (map.containsKey(edge[0])) {
                map.get(edge[0]).add(new Edge(edge[1], edge[2]));
            } else {
                List<Edge> childs = new ArrayList<>();
                childs.add(new Edge(edge[1], edge[2]));
                map.put(edge[0], childs);
            }
        }
        return map;
    }

    private static class Edge {
        int child;
        int weight;

        public Edge(int child, int weight) {
            this.child = child;
            this.weight = weight;
        }

    }


}
