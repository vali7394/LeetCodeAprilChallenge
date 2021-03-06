package com.coding.leetcode.amazon.graph;/*
  @created 6/26/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SequenceReconstruction {


    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int[] inDegree = new int[org.length];
        Map<Integer, List<Integer>> graph = buildGraph(seqs,inDegree);
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<org.length ; i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }

        if(queue.size() != 1){
            return false;
        }

        while (!queue.isEmpty()){
            return false;
        }
return true;
    }


        private Map<Integer, List<Integer>> buildGraph(List<List<Integer>> seqs, int[] indegree) {
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (List<Integer> course : seqs) {
                indegree[course.get(1)]++;
                if (graph.containsKey(course.get(0))) {
                    graph.get(course.get(0)).add(course.get(1));
                } else {
                    List<Integer> preReqs = new ArrayList<>();
                    preReqs.add(course.get(1));
                    graph.put(course.get(0), preReqs);
                }
            }
            return graph;
        }
}


/**
 Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.



 Example 1:

 Input: org = [1,2,3], seqs = [[1,2],[1,3]]
 Output: false
 Explanation: [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
 Example 2:

 Input: org = [1,2,3], seqs = [[1,2]]
 Output: false
 Explanation: The reconstructed sequence can only be [1,2].
 Example 3:

 Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
 Output: true
 Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 Example 4:

 Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
 Output: true


 Constraints:

 1 <= n <= 10^4
 org is a permutation of {1,2,...,n}.
 seqs[i][j] fits in a 32-bit signed integer.
 **/