package com.coding.leetcode.amazon.graph;/*
  @created 6/25/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReconstructItinerary {


    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,Integer> inDegree = new HashMap<>();
        Map<String,PriorityQueue<String>> graph = buildGraph(tickets,inDegree);
        Stack<String> flights = new Stack<>();
        flights.push("JFK");
        List<String> result = new ArrayList<>();
        while (!flights.isEmpty()) {
            String source = flights.peek();

            if(graph.get(source).size()==0){
                result.add(source);
                flights.pop();
            } else {
                Queue<String> ticketQueue = graph.get(source);
                for(String dest : ticketQueue){
                    flights.add(dest);
                }
                ticketQueue.clear();
            }

        }
         Collections.reverse(result);
        return result;
    }


    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets,Map<String,Integer> inDegree){

        var graph = new HashMap<String,PriorityQueue<String>>();
        for(List<String> ticket : tickets) {
            inDegree.put(ticket.get(1), inDegree.getOrDefault(ticket.get(1), 0) + 1);
            if(graph.containsKey(ticket.get(0))){
                graph.get(ticket.get(0)).add(ticket.get(1));
            }else {
                PriorityQueue<String> edges = new PriorityQueue<String>();
                edges.offer(ticket.get(1));
                graph.put(ticket.get(0),edges);
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        String[][] input = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        List<List<String>> inputList = Stream.of(input).map(strings->List.of(strings)).collect(Collectors.toList());
        ReconstructItinerary itinerary = new ReconstructItinerary();
        itinerary.findItinerary(inputList);
    }

}


/**
 Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

 Note:

 If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.
 One must use all the tickets once and only once.
 Example 1:

 Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 Example 2:

 Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 But it is larger in lexical order.

 **/