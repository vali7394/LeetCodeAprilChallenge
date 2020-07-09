package com.coding.leetcode.amazon.graph;/*
  @created 6/25/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Vertex>> graph = buildGraph(equations,values);
        Set<String> visited = new HashSet<>();
        double[] result = new double[queries.size()];
        for(int i=0; i<queries.size(); i++){
            result[i] = calculateResultDfs(queries.get(1).get(0),queries.get(1).get(0),1,graph,visited);
        }
        return result;
    }


    private double calculateResultDfs(String start, String end ,double result, Map<String, List<Vertex>> graph, Set<String> visited){
        if(!graph.containsKey(start) || result==-1 || visited.contains(start)){
            return -1;
        }

        if(start.equalsIgnoreCase(end)) {
            return 1;
        }

        List<Vertex> neighbours = graph.get(start);
        visited.add(start);

        for(Vertex vertex : neighbours){
            double value = calculateResultDfs(vertex.letter,end,result*vertex.val,graph,visited);
            if(value!=-1){
                return value;
            }
        }
        return -1;
    }


    private Map<String, List<Vertex>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Vertex>> edgeMap = new HashMap<>();
        for (var i = 0; i < equations.size(); i++) {
            List<String> edge = equations.get(i);
            var value = values[i];
            Vertex vertexOne = new Vertex(edge.get(1), value);
            Vertex vertexTwo = new Vertex(edge.get(0), 1 / value);
            if (edgeMap.containsKey(edge.get(0))) {
                edgeMap.get(edge.get(0)).add(vertexOne);
            } else {
                var neighbours = new ArrayList<Vertex>();
                neighbours.add(vertexOne);
                edgeMap.put(edge.get(0), neighbours);
            }

            if(edgeMap.containsKey(edge.get(1))){
                edgeMap.get(edge.get(1)).add(vertexTwo);
            } else {
                var neighboursTwo = new ArrayList<Vertex>();
                neighboursTwo.add(vertexTwo);
                edgeMap.put(edge.get(1), neighboursTwo);
            }

        }
        return edgeMap;
    }

    private class Vertex{
        String  letter;
        double val;

        public Vertex(String letter, double val) {
            this.letter = letter;
            this.val = val;
        }
    }
}



/**
 Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

 According to the example above:

 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].


 The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 **/