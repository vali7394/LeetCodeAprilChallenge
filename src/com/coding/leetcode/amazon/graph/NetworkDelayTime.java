package com.coding.leetcode.amazon.graph;/*
  @created 6/25/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {



    public int networkDelayTime(int[][] edges, int N, int K) {

        // if dis(v) < dis(u) + weight[u,v] ==> dis(v) = dis(u) + weight[u,v];

        int[] distance = new int[N+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[K] = 0;
        for(int i=1; i<N ; i++){
            for(int[] edge : edges){
                if(distance[edge[0]]!=Integer.MAX_VALUE && distance[edge[1]]>distance[edge[0]]+edge[2]){
                    distance[edge[1]] = distance[edge[0]]+edge[2];
                }
            }

        }
        int result = 0;
            for(int i=1 ; i<=N; i++){
                result = Math.max(result,distance[i]);
            }

        if(result==Integer.MAX_VALUE) return -1;
        return result;
    }

    public int networkDelayTimeDjs(int[][] times, int N, int K) {

        //To Track already visited node to avoid loops
        boolean[] visited = new boolean[N+1];
        Map<Integer, List<Node>> graph = buildMap(times);
        //This is similar Dkj's single source shortest path problem.So We will visit all edges starting with min weight

        //Maintain a PQ which sorts the nodes in ASC based on weight time
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::getWeight));

        queue.add(new Node(K,0));
        int result=0;
        while (!queue.isEmpty()){
            Node node = queue.poll();
            //If node is already visited continue.
            if(visited[node.destination]==true){
                continue;
            }

            int curDis = node.weight;
            visited[node.destination] = true;
            result = curDis;
            // Making the visited nodes count
            N--;
            //If all the nodes covered and this will be the edge with max weight.
            if(N==0){
                return result;
            }
            // Getting the edges of current node
            List<Node> edges = graph.get(node.destination);
            if(edges!=null){
                for(Node edge : edges){
                    // Add the vertex to queue with edge weight + parent vertex distance
                    queue.offer(new Node(edge.destination,curDis+edge.weight));
                }
            }
        }
            return -1;
        }




        private Map<Integer, List<Node>> buildMap(int[][] times){
            var graph = new HashMap<Integer, List<Node>>();

            for(int[] time : times){
                var node = new Node(time[1],time[2]);
                if(graph.containsKey(time[0])){
                    graph.get(time[0]).add(node);
                } else {
                    List<Node> queue = new ArrayList<>();
                    queue.add(node);
                    graph.put(time[0],queue);
                }
            }

            return graph;
        }

        // This is to maintain edge data
        private class Node {
            int destination;
            int weight;

            public Node(int destination, int weight) {
                this.destination = destination;
                this.weight = weight;
            }

            public int getDestination() {
                return destination;
            }

            public int getWeight() {
                return weight;
            }
    }

    public static void main(String[] args){
        int[][] input = new int[][]{{1,2,1},{2,1,3}};
        NetworkDelayTime delayTime = new NetworkDelayTime();
        System.out.println(delayTime.networkDelayTime(input,2,2));
    }

}


/**

 There are N network nodes, labelled 1 to N.

 Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

 Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.



 Example 1:



 Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
 Output: 2


 Note:

 N will be in the range [1, 100].
 K will be in the range [1, N].
 The length of times will be in the range [1, 6000].
 All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.

 **/