package com.coding.leetcode.amazon.graph;/*
  @created 6/28/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        if(edges==null || edges.length==0){
            return new int[]{};
        }
        var disjoint = new Disjoint();
        disjoint.makeSet(edges);
        var result = new ArrayList<int[]>();
        for(int[] edge : edges){
            int parentI = disjoint.find(disjoint.map,edge[0]);
            int parentJ = disjoint.find(disjoint.map,edge[1]);

            if(parentI==parentJ){
                result.add(edge);
            }
            disjoint.union(disjoint.map,edge[0],edge[1]);
        }

        return result.isEmpty() ? new int[]{} : result.get(result.size()-1);
    }
    class Node {
        int parent;
        int rank;
        Node(int parent,int rank){
            this.parent = parent;
            this.rank = rank;
        }
    }

    class Disjoint {
        Map<Integer,Node> map = new HashMap<Integer,Node>();

        public void makeSet(int[][] edges){
            for(int[] n : edges){
                map.put(n[0], new Node(n[0],0));
                map.put(n[1], new Node(n[1],0));
            }
        }

        public int find(Map<Integer,Node> map, int i){
            if(map.get(i).parent!=i){
                map.get(i).parent = find(map,map.get(i).parent);
            }
            return map.get(i).parent;
        }

        public void union(Map<Integer,Node> map, int i, int j){
            int parentI = find(map,i);
            int parentJ = find(map,j);
            if(map.get(parentI).rank < map.get(parentJ).rank){
                map.get(parentI).parent = map.get(j).parent;
            }else if(map.get(parentJ).rank < map.get(parentI).rank){
                map.get(parentJ).parent = map.get(i).parent;
            } else {
                map.get(parentI).parent = map.get(parentJ).parent;
                map.get(parentJ).rank++;
            }
        }
}

    public static void main(String[] args) {
        RedundantConnection connection = new RedundantConnection();
        int[][] input = new int[][]{{1,5},{3,4},{3,5},{4,5},{2,4}};
        int[] result = connection.findRedundantConnection(input);
        System.out.println(result[0] + " " + result[1]);

    }

}
