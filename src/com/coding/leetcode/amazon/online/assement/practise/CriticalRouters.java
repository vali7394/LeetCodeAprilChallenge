package com.coding.leetcode.amazon.online.assement.practise;/*
  @created 7/10/20
  @Author b008245 - Meeravali Shaik 
 */

import java.util.List;

public class CriticalRouters {

    /*public List<Integer> getCriticalRouters(int numNodes, int numEdges, int[][] edges) {

    }
*/

    public static void main(String[] args) {
        int[] time = new int[1];
        int[] tracks = new int[2];
        for(int i=0; i<tracks.length;i++){
            tracks[i] = time[0]++;
            System.out.println(tracks[i]);
        }
    }

}


/**
 You are given an undirected connected graph. An articulation point (or cut vertex) is defined as a vertex which, when removed along with associated edges,
 makes the graph disconnected (or more precisely, increases the number of connected components in the graph). The task is to find all articulation points in the given graph.

 Input:
 The input to the function/method consists of three arguments:

 numNodes, an integer representing the number of nodes in the graph.
 numEdges, an integer representing the number of edges in the graph.
 edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
 Output:
 Return a list of integers representing the critical nodes.

 Example:

 Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]


 Output: [2, 3, 5]
 **/