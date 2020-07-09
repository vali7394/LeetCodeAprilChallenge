package com.coding.leetcode.amazon.sorting;/*
  @created 6/26/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {


    public int[] canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        Map<Integer, List<Integer>> graph = buildGraph(prerequisites,degree);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i<numCourses ; i++){
            if(degree[i]==0) {
                queue.offer(i);
            }
        }

        if(queue.isEmpty()){
            return new int[]{};
        }
        int[] result = new int[numCourses];
        int r=numCourses-1;
        while (!queue.isEmpty()){
            Integer course = queue.poll();
            degree[course] = -1;
            result[r] = course;
            r--;
            if(graph.containsKey(course)){
                List<Integer> preRes = graph.get(course);
                for(int req : preRes){
                    int inDegree = degree[req];
                    inDegree--;
                    if(inDegree==0){
                        queue.offer(req);
                    }
                        degree[req] = inDegree;
                }

            }
        }

        for(int i=0 ; i<numCourses ; i++){
            if(degree[i]!=-1){
                return new int[]{};
            }
        }
        return result;
    }


    private Map<Integer, List<Integer>> buildGraph(int[][] prerequisites, int[] indegree) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] course : prerequisites) {
            indegree[course[1]]++;
            if (graph.containsKey(course[0])) {
                graph.get(course[0]).add(course[1]);
            } else {
                List<Integer> preReqs = new ArrayList<>();
                preReqs.add(course[1]);
                graph.put(course[0], preReqs);
            }
        }
        return graph;
    }

    public static void main(String[] args) {
        var schedule = new CourseSchedule();
        schedule.canFinish(2,new int[][]{{1,0}});
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
 **/