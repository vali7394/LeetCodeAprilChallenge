package com.coding.leetcode.amazon.online.assement;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */
import java.util.*;
import java.util.stream.Collectors;

public class CriticalRouters {


    /**

     We record the timestamp that we visit each node. For each node, we check every neighbor
     except its parent and return a smallest timestamp in all its neighbors.
     If this timestamp is strictly less than the node's timestamp, we know that this node is somehow in a cycle.
        Otherwise, this edge from the parent to this node is a critical connection

     */

    public static void main(String[] args) {
        int[][] connections = new int[][]{{0,1},{1,2},{2,0},{1,3}};
        CriticalRouters routers = new CriticalRouters();
        List<List<Integer>> inpit = Arrays.stream(connections)
            .map(i -> Arrays.stream(i).boxed().collect(Collectors.toList()))
            .collect(Collectors.toList());
        routers.criticalConnections(4,inpit);
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer,List<Integer>> graph = buildGraph(n, connections);
        boolean[] visited = new boolean[n];
        List<List<Integer>> criticalConns = new ArrayList<>();
        int[] visitedTimes = new int[n];
        findCriticalConnections(graph,0,criticalConns,visited,0,visitedTimes,-1);
        return criticalConns;
    }


    private void findCriticalConnections(Map<Integer, List<Integer>> graph, int node,
        List<List<Integer>> criticalConns, boolean[] visited, int timeTracker, int[] visitedTimes,
        int parent) {
        visited[node] = true;
        visitedTimes[node] = timeTracker;
        int lowTime = visitedTimes[node];
        timeTracker++;
        List<Integer> connections = graph.get(node);
        if (connections != null && !connections.isEmpty()) {
            for (int dest : connections) {
                if (dest == parent) {
                    continue;
                }
                if (!visited[dest]) {
                    findCriticalConnections(graph, dest, criticalConns, visited, timeTracker,
                        visitedTimes, node);
                }
                visitedTimes[node] = Math.min(visitedTimes[node], visitedTimes[dest]);
                if (lowTime < visitedTimes[dest]) {
                    criticalConns.add(List.of(node, dest));
                }
            }
        }

    }

    public Map<Integer,List<Integer>> buildGraph(int n, List<List<Integer>> connections){


        var graph = new HashMap<Integer,List<Integer>>();

        for(int i=0; i<n ; i++){
            graph.put(i,new ArrayList<>());
        }
        for(List<Integer> connection : connections){
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
        return graph;
    }
}
