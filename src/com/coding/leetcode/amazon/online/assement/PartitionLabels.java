package com.coding.leetcode.amazon.online.assement;/*
  @created 7/6/20
  @Author ** - Meeravali Shaik
 */

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        if(S==null || S.isEmpty()){
            return Collections.emptyList();
        }

        Map<Character,Integer> lastOcurMap = new HashMap<>();

        for(int i=0; i<S.length(); i++){
            lastOcurMap.put(S.charAt(i),0);
        }

        List<Integer> result = new ArrayList<>();

        int startPos= 0;
        int curPos = 0;

        for(int i=0; i<S.length(); i++){
            int lastOcur = lastOcurMap.get(S.charAt(i));
             curPos = Math.max(curPos,lastOcur);
            if(curPos==i){
                result.add(i-startPos+1);
                startPos=i+1;
            }

        }
        System.out.println(result);
        return result;

    }

    public static void main(String[] args) {
        PartitionLabels labels = new PartitionLabels();
        labels.partitionLabels("ababcbacadefegdehijhklij");
    }
}
