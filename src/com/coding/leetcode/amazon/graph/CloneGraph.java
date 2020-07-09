package com.coding.leetcode.amazon.graph;/*
  @created 7/2/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Integer,Node> helperMap = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<>());
        helperMap.put(newNode.val,newNode);
        for(Node neighbor : node.neighbors){
            if(helperMap.containsKey(neighbor.val)){
                newNode.neighbors.add(helperMap.get(neighbor.val));
            }else {
                Node temp = new Node(neighbor.val, new ArrayList<>());
                newNode.neighbors.add(temp);
                cloneDfs(helperMap,temp,neighbor);
            }

        }
        return newNode;
    }

    private void cloneDfs(Map<Integer,Node> helperMap, Node newNode, Node oldNode){
        helperMap.put(newNode.val,newNode);

        for(Node node : oldNode.neighbors){

            if(helperMap.containsKey(node.val)){
                newNode.neighbors.add(helperMap.get(node.val));
            } else {
                Node temp = new Node(node.val,new ArrayList<>());
                newNode.neighbors.add(temp);
                cloneDfs(helperMap,temp,node);
            }

        }

    }

    public Node cloneGraphBfs(Node node) {

        Node clone = new Node(node.val, new ArrayList<>());
        Map<Integer,Node> visitedMap = new HashMap<>();
        Queue<QueueNode> queue  =new LinkedList<>();
        queue.offer(new QueueNode(node,clone));
        visitedMap.put(node.val,clone);
        while (!queue.isEmpty()){
            QueueNode queueNode = queue.poll();
            for(Node neighbors : queueNode.oldNode.neighbors){
                if(visitedMap.containsKey(neighbors.val)){
                    queueNode.newNode.neighbors.add(visitedMap.get(neighbors.val));
                } else {
                    Node temp = new Node(neighbors.val, new ArrayList<>());
                    queueNode.newNode.neighbors.add(temp);
                    visitedMap.put(neighbors.val,temp);
                    queue.offer(new QueueNode(neighbors,temp));
                }

            }
        }
        return clone;
    }

    private class QueueNode {
        Node oldNode;
        Node newNode;

        public QueueNode(Node oldNode, Node newNode) {
            this.oldNode = oldNode;
            this.newNode = newNode;
        }
    }

}


class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}