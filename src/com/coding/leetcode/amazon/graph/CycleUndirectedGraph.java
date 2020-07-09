package com.coding.leetcode.amazon.graph;/*
  @created 6/27/20
  @Author ** - Meeravali Shaik
 */

import java.util.Arrays;
public class CycleUndirectedGraph {


    public static boolean hasCycle(int n , int[][] edges){
        int[] parent = new int[n];
        Arrays.fill(parent,-1);

        for(int[] edge : edges){
            int x = findParent(parent,edge[0]);
            int y = findParent(parent,edge[1]);
            if(x==y){
                return true;
            }
            union(parent,edge[0],edge[1]);
        }

        return false;

    }

    public static void main(String[] args) {
        int[][] edges = {{0,1},{2,3},{0,2}};
        System.out.println(hasCycle(8,edges));
    }

    public static void findCycleBySets(int[][] edges, int n){
        Node[] nodes = new Node[n];
        makeNodes(nodes,n);
        return;
    }

    private static void makeNodes(Node[] nodes, int n){
        for(int i=0; i<n; i++){
            nodes[i] = new Node(i,0);
        }
    }

    private static int find(Node[] nodes, int i){
        if(nodes[i].parent!=i){
            nodes[i].parent = find(nodes,nodes[i].parent);
        }
        return nodes[i].parent;
    }


    private static void union(Node[] nodes , Node i , Node j ){

        int rootParentI = find(nodes,i.parent);
        int rootParentJ = find(nodes,j.parent);

        if(nodes[rootParentI].rank < nodes[rootParentJ].rank) {
            nodes[rootParentJ].parent = rootParentI;
        } else if (nodes[rootParentI].rank > nodes[rootParentJ].rank) {
            nodes[rootParentI].parent = rootParentJ;
        } else {
            nodes[rootParentI].parent = rootParentJ;
            nodes[rootParentJ].rank++;
        }

    }


    private static int findParent(int[] parent , int i){
       if(parent[i]==-1){
           return i;
       }
       return findParent(parent,parent[i]);
    }

    private static void union(int[] parent, int i , int j){
        int xSet = findParent(parent,i);
        int ySet = findParent(parent,j);
        parent[xSet] = ySet;
    }


    static class  Node {
        int data;
        int parent;
        int rank;

        public Node(int data, int parent, int rank) {
            this.data = data;
            this.parent = parent;
            this.rank = rank;
        }

        public Node(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

}
