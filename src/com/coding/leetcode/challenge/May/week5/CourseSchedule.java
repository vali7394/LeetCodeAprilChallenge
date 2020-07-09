package com.coding.leetcode.challenge.May.week5;/*
  @created 5/29/20
  @Author  - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites);
        var courseQueue = new LinkedList<Integer>();

        for(int k : graph.keySet()){
            List<Integer> dependentCourses = graph.get(k);
            for(int j : dependentCourses){
                inDegree[j] = inDegree[j]+1;
            }
        }

        for(int i=0;i<numCourses ;i++){
            if(inDegree[i]==0){
                courseQueue.offer(i);
            }
        }
        if(courseQueue.isEmpty()){
            return false;
        }
        while (!courseQueue.isEmpty()){
            int course = courseQueue.poll();
            List<Integer> depenCourses = graph.get(course);
            inDegree[course] = -1;
            if(depenCourses!=null) {
                for (int i : depenCourses) {
                    inDegree[i] = inDegree[i] - 1;
                    if (inDegree[i] == 0) {
                        courseQueue.offer(i);
                    }
                }
            }
        }

        for(int i : inDegree){
            if(i!=-1){
                return false;
            }
        }

        return true;
    }


    private static Map<Integer, List<Integer>> buildGraph(int[][] prerequisites){
        return Stream.of(prerequisites).collect(Collectors.groupingBy(result -> result[0],
            Collectors.mapping(result -> result[1], Collectors.toList())));
    }


}

/**
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?



 Example 1:

 Input: numCourses = 2, prerequisites = [[1,0]]
 Output: true
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0. So it is possible.
 Example 2:

 Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 Output: false
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0, and to take course 0 you should
 also have finished course 1. So it is impossible.


 Constraints:

 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 1 <= numCourses <= 10^5

 */