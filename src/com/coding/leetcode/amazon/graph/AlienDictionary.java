package com.coding.leetcode.amazon.graph;/*
  @created 6/25/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {

    public String alienOrder(String[] words) {

        Map<String,Integer> inDegree = new HashMap<>();
        Set<String> vertices = new LinkedHashSet<>();
        Set<String> duplicateEdges = new HashSet<>();
        Map<String, List<String>> graph = buildGraph(words,inDegree,vertices,duplicateEdges);
        Queue<String> queue = new LinkedList<>();

        for(String verticx : vertices){
            if(!inDegree.containsKey(verticx)){
                queue.offer(verticx);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()){
            findTheOrder(graph,queue,result,inDegree);
        }
        return result.toString();
    }


    private void findTheOrder(Map<String, List<String>> graph, Queue<String> queue,
        StringBuilder result,Map<String,Integer> inDegree) {
        if(queue.isEmpty()){
            return;
        }
        String letter = queue.poll();
        result.append(letter);
        List<String> neigh = graph.get(letter);
        if(neigh!=null){
            for(String nextLet : neigh){
                if(inDegree.containsKey(nextLet)){
                    int indegr = inDegree.get(nextLet);
                    indegr--;
                    if(indegr==0){
                        inDegree.remove(nextLet);
                        queue.add(nextLet);
                    } else {
                        inDegree.put(nextLet,indegr);
                    }
                }else {
                    queue.add(nextLet);
                }
            }
        }

    }

    private Map<String, List<String>> buildGraph(String[] words,Map<String,Integer> inDegree,Set<String> vertices,Set<String> duplicateEdges){
        Map<String, List<String>> graph = new HashMap<>();
        for(String word : words) {
            String[] letters = word.split("");
            for (int i = 0; i < letters.length - 1; i++) {
                if (!letters[i].equalsIgnoreCase(letters[i + 1]) && !duplicateEdges.contains(letters[i] + letters[i + 1])) {
                        duplicateEdges.add(letters[i] + letters[i + 1]);
                        vertices.add(letters[i]);
                        vertices.add(letters[i + 1]);
                        inDegree.put(letters[i + 1], inDegree.getOrDefault(letters[i + 1], 0) + 1);
                        if (graph.containsKey(letters[i])) {
                            graph.get(letters[i]).add(letters[i + 1]);
                        } else {
                            List<String> nextLetter = new ArrayList<>();
                            nextLetter.add(letters[i + 1]);
                            graph.put(letters[i], nextLetter);
                        }
                }
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        AlienDictionary dictionary = new AlienDictionary();
        System.out.println(dictionary.alienOrder(new String[]{"Z","X"}));
    }

}


/**
 There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

 Example 1:

 Input:
 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]

 Output: "wertf"
 Example 2:

 Input:
 [
 "z",
 "x"
 ]

 Output: "zx"
 Example 3:

 Input:
 [
 "z",
 "x",
 "z"
 ]

 Output: ""

 Explanation: The order is invalid, so return "".
 Note:

 You may assume all letters are in lowercase.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.
 **/