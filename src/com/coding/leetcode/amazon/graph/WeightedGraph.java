package com.coding.leetcode.amazon.graph;/*
  @created 6/23/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeightedGraph {

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1, 2, 10}, {1, 3, 80}, {3, 4, 70}, {2, 3, 6}, {2, 5, 20},
            {5, 7, 10}, {7, 6, 5}, {5, 6, 50}};
        findMinCostToAllVertices(7,edges);
    }

    public static void findMinCostToAllVertices(int n , int[][] edges){

        int[] burntTime = new int[n+1];
        Arrays.fill(burntTime,Integer.MAX_VALUE);
        boolean[] burnStatus = new boolean[n+1];
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(1);
        burnStatus[1] = true;
        burntTime[1] = 0;
        Map<Integer, List<Node>> graph = buildGraph(n,edges);
        bfs(graph,burnStatus,burntTime,queue);
        for(int i=1;i<burntTime.length;i++){
            System.out.println("Burnt Time for Node" + i + burntTime[i]);
        }

    }

    private static void bfs(Map<Integer, List<Node>> graph, boolean[] burnStatus, int[] burntTime,
        Queue<Integer> queue) {
        if(queue.isEmpty()){
            return;
        }
        int parent = queue.poll();
        List<Node> nodes = graph.get(parent);
        if(nodes==null){
            return;
        }
        Collections.sort(nodes,Comparator.comparing(Node::getVal));
        for(Node node : nodes){
        if(!burnStatus[node.child]) {
            burnStatus[node.child] = true;
            burntTime[node.child] = Math
                .min(burntTime[node.child], node.val + burntTime[parent]);
            queue.offer(node.child);
            bfs(graph,burnStatus,burntTime,queue);
        }
    }

    }

    private static Map<Integer, List<Node>> buildGraph(int n , int[][] edges){
        Map<Integer, List<Node>> graph = new HashMap<>();
        for(int[] edge : edges){
            Node node = new Node(edge[1], edge[2]);
            if(graph.containsKey(edge[0])){
                graph.get(edge[0]).add(node);
            }else {
                List<Node> list = new ArrayList<>();
                list.add(node);
                graph.put(edge[0],list);
            }
        }
        return graph;
    }

    private static class Node {
        int child;
        int val;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node(int child, int val) {
            this.child = child;
            this.val = val;
        }

    }

}


/**




 Dijkstra's Algorithms

 */