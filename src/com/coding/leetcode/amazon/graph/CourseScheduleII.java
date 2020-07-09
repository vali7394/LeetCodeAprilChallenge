package com.coding.leetcode.amazon.graph;/*
  @created 6/21/20
  @Author ** - Meeravali Shaik
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDegrees = new int[numCourses];
        Queue<Integer> courseQueue = new LinkedList<>();
        Map<Integer, List<Integer>> courseMap = buildGraph(prerequisites);
        int[] result = new int[numCourses];
        for(int key : courseMap.keySet()){
            List<Integer> neighbours = courseMap.get(key);
            for(int j : neighbours){
                inDegrees[j] = inDegrees[j]+1;
            }

        }
        for(int i=0; i<numCourses; i++){
            if(inDegrees[i]==0){
                courseQueue.offer(i);
            }
        }
        if(courseQueue.isEmpty()){
            return new int[]{};
        }
        int n = numCourses-1;
        while (!courseQueue.isEmpty()){
            int course = courseQueue.poll();
            result[n] = course;
            n--;
            inDegrees[course] = -1;
            List<Integer> dependentCourses = courseMap.get(course);
            if(dependentCourses!=null) {
                for (int i : dependentCourses) {
                    inDegrees[i] = inDegrees[i] - 1;
                    if (inDegrees[i] == 0) {
                        courseQueue.offer(i);
                    }
                }
            }
        }
        for(int i=0 ; i<numCourses; i++){
            if(inDegrees[i]!=-1){
                return new int[]{};
            }
        }
        return result;
    }

    private static Map<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        return Stream.of(prerequisites).collect(Collectors.groupingBy(result -> result[0],
            Collectors.mapping(result -> result[1], Collectors.toList())));
    }


    public static void main(String[] args) {
        CourseScheduleII courseSchedule = new CourseScheduleII();
        int[] result = courseSchedule.findOrder(3, new int[][]{{0,2},{1,2},{2,0}});
        for(int i : result){
            System.out.println(i);
        }
    }

}

/**
 There are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 Example 1:

 Input: 2, [[1,0]]
 Output: [0,1]
 Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 course 0. So the correct course order is [0,1] .
 Example 2:

 Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 Output: [0,1,2,3] or [0,2,1,3]
 Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 Note:

 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 AcceptedThere are a total of n courses you have to take, labeled from 0 to n-1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 Example 1:

 Input: 2, [[1,0]]
 Output: [0,1]
 Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 course 0. So the correct course order is [0,1] .
 Example 2:

 Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 Output: [0,1,2,3] or [0,2,1,3]
 Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 Note:

 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 You may assume that there are no duplicate edges in the input prerequisites.
 Accepted
 **/