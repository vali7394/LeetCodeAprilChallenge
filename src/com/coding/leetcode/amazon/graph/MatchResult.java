package com.coding.leetcode.amazon.graph;/*
  @created 6/20/20
  @Author ** - Meeravali Shaik
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatchResult {
    String winningTeam;
    String losingTeam;

    public MatchResult(String winningTeam, String losingTeam) {
        this.winningTeam = winningTeam;
        this.losingTeam = losingTeam;
    }

    public static boolean canTeamABeatTeamB(List<MatchResult> matches, String teamA, String teamB){

        List<MatchResult> matchResults = List
            .of(new MatchResult("a", "b"), new MatchResult("c", "d")
                , new MatchResult("a", "d"), new MatchResult("b", "c"), new MatchResult("a", "e"));
        Map<String, Set<String>> graph = buildGraph(matchResults);
        System.out.println(graph);

        return true;
    }

    public static void main(String[] args) {
       // canTeamABeatTeamB(null,"","");
        int[][] flights = {{4,1,1},{1,2,3},{0,3,2},{0,4,10},{3,1,1},{1,4,3}};
        System.out.println(buildFlightsGraph(flights));
    }

    private static Map<String, Set<String>> buildGraph(List<MatchResult> matches) {
        var map = matches.stream()
            .collect(Collectors.groupingBy(result -> result.winningTeam,
                Collectors.mapping(result -> result.losingTeam, Collectors.toSet())));
        return map;

    }


    private static Map<Integer,List<Integer>> buildFlightsGraph(int[][] flights){
        return Stream.of(flights).collect(Collectors.groupingBy(flight -> flight[0],
            Collectors.mapping(flight -> flight[1], Collectors.toList())));
    }


    private static boolean searchOption(Map<String, List<String>> graph, String teamA,
        String teamB, Set<String> visited) {

        if (teamA == teamB) {
            return true;
        }

        if (!graph.containsKey(teamA) && visited.contains(teamA)) {
            return false;
        }
        visited.add(teamA);
        for (String team : graph.get(teamA)) {
            return searchOption(graph, team, teamB, visited);
        }
        return false;
    }

}




/**
 suppose you were given a list of the outcomes of matches between pairs of teams, with each outcome being a win or loss.
 A natural question is as follows: given teams A and B, is there
 a sequence of teams starting with A and ending with B such that each team in the sequence has beaten the next team in the sequence?

 */