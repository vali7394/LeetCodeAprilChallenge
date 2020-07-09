package com.coding.leetcode.amazon.graph;/*
  @created 6/27/20
  @Author ** - Meeravali Shaik
 */


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
public class ConnectingCitiesMinimumCost {

    public int minimumCost(int N, int[][] connections) {
        Arrays.sort(connections, Comparator.comparingInt(s1->s1[2]));
        Disjoint disjoint = new Disjoint();
        disjoint.makeSet(N);
        int result = 0;
        int n = N;
        for(int[] connection : connections){

            int sourceParent = disjoint.find(disjoint.disjointSet,connection[0]);
            int destParent = disjoint.find(disjoint.disjointSet,connection[1]);

            if(sourceParent==destParent){
                continue;
            }
            disjoint.union(disjoint.disjointSet,connection[0],connection[1]);
            result+=connection[2];
            n--;

        }
        return n==1?result:-1;
    }

    public static void main(String[] args) {
        int[][] input = {{1,2,5},{1,3,6},{2,3,1}};
        ConnectingCitiesMinimumCost minimumCost = new ConnectingCitiesMinimumCost();
        int n = minimumCost.minimumCost(3,input);
        System.out.println(n);
    }
}

class Disjoint{
    Map<Integer, City> disjointSet = new HashMap<>();

    public void makeSet(int n){
        for(int i=1; i<=n ; i++){
            disjointSet.put(i,new City(i,0));
        }
    }

    public int find(Map<Integer, City> disjointSet, int i){
        if (disjointSet.get(i).parent != i) {
            disjointSet.get(i).parent = find(disjointSet, disjointSet.get(i).parent);
        }
        return disjointSet.get(i).parent;
    }

    public void union(Map<Integer, City> disjointSet, int i, int j){

        int parentI = find(disjointSet,i);
        int parentJ = find(disjointSet,j);

        if(disjointSet.get(parentI).rank < disjointSet.get(parentJ).rank){
            disjointSet.get(parentI).parent = parentJ;
        } else if(disjointSet.get(parentI).rank > disjointSet.get(parentJ).rank){
            disjointSet.get(parentJ).parent = parentI;
        } else {
            disjointSet.get(parentI).parent = parentJ;
            disjointSet.get(parentJ).rank++;
        }
    }

}

class City {

        int parent;
        int rank;

    public City(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }

}

/**

 There are N cities numbered from 1 to N.

 You are given connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.  (A connection is bidirectional: connecting city1 and city2 is the same as connecting city2 and city1.)

 Return the minimum cost so that for every pair of cities, there exists a path of connections (possibly of length 1) that connects those two cities together.  The cost is the sum of the connection costs used. If the task is impossible, return -1.



 Example 1:



 Input: N = 3, connections = [[1,2,5],[1,3,6],[2,3,1]]
 Output: 6
 Explanation:
 Choosing any 2 edges will connect all cities so we choose the minimum 2.
 Example 2:



 Input: N = 4, connections = [[1,2,3],[3,4,4]]
 Output: -1
 Explanation:
 There is no way to connect all cities even if all edges are used.


 Note:

 1 <= N <= 10000
 1 <= connections.length <= 10000
 1 <= connections[i][0], connections[i][1] <= N
 0 <= connections[i][2] <= 10^5
 connections[i][0] != connections[i][1]


 */