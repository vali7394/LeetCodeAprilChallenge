package com.coding.leetcode.amazon.online.assement;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */
import java.util.*;
import java.util.stream.Collectors;

public class OptimalUtilization {

    public List<int[]> solution(List<int[]> a, List<int[]> b, int target){

        if(a==null || b==null || a.isEmpty() || b.isEmpty()){
            return Collections.emptyList();
        }

        Collections.sort(a, Comparator.comparingInt(i1->i1[0]));
        Collections.sort(b, Comparator.comparingInt(i1->i1[0]));

        TreeMap<Integer,List<int[]>> optimalMap = new TreeMap<>();

        int i=0;
        int j= b.size()-1;

        while(i<a.size() && j>=0){
            int val = a.get(i)[1] + b.get(j)[1];
            if(val>target){
                j--;
            }
            else if(val <= target){
                if(optimalMap.containsKey(val)){
                    optimalMap.get(val).add(new int[]{a.get(i)[0], b.get(j)[0]});
                }else {
                    var list = new ArrayList<int[]>();
                    list.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    optimalMap.put(val,list);
                }
                i++;
            }
        }
        return optimalMap.floorEntry(target).getValue();
    }

    public static void main(String[] args) {
        OptimalUtilization main = new OptimalUtilization();
        int[] maxTravelDists = {7000, 10000, 10000};
        int[][][] forwardRouteLists = {{{1, 2000}, {2, 4000}, {3, 6000}},
            {{1, 2000}, {2, 5000}, {3, 7000}, {4, 10000}},
            {{1, 3000}, {2, 5000}, {3, 7000}, {4, 10000}}};
        int[][][] returnRouteLists = {{{1, 2000}},
            {{1, 2000}, {2, 3000}, {3, 4000}, {4, 5000}},
            {{1, 2000}, {2, 2000}, {3, 4000}, {4, 4000}}};
        for (int i = 0; i < maxTravelDists.length; ++i) {
                List<int[]> result = main.solution(Arrays.stream(forwardRouteLists[i]).collect(Collectors.toList()),
                    Arrays.stream(returnRouteLists[i]).collect(
                        Collectors.toList()),
                    maxTravelDists[i]);
                result.forEach(res->{
                    System.out.print(res[0] + "  " + res[1]);
                });
                System.out.println();
        }
    }
}
