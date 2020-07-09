package com.coding.leetcode.amazon;/*
  @created 6/18/20
  @Author ** - Meeravali Shaik
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class KNearestPostOffices {

    private List<int[]> nearestPostOffices(int[][] input, int[] me,int k){
        var map = new HashMap<int[],Double>();
        for(int[] postOffice : input){
            map.put(postOffice,findDistance(me,postOffice));
        }
        var queue = new PriorityQueue<int[]>(Comparator.comparing(map::get).reversed());

        for (int[] office : input){
            queue.offer(office);
            if(queue.size()>k){
                queue.poll();
            }
        }

        int l =0 ;
        List<int[]> result = new ArrayList<>(k);
        while (!queue.isEmpty() && l<k){
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;
    }

    private double findDistance(int[] me , int[] postOffice){
        int x = (me[0]-postOffice[0])*(me[0]-postOffice[0]);
        int y = (me[1]-postOffice[1])*(me[1]-postOffice[1]);
        return Math.sqrt(x+y);
    }

    public static void main(String[] args) {
        KNearestPostOffices postOffices = new KNearestPostOffices();
        int[][] input = {{-16, 5}, {-1, 2}, {4, 3}, {10, -2}, {0, 3}, {-5, -9}};
        List<int[]> offices = postOffices.nearestPostOffices(input,new int[]{0,0},3);
        for(int[] value : offices){
            System.out.println(value[0] + "  " + value[1]);
        }
    }

}


/**

 Find the k post offices located closest to you, given your location and a list of locations of all post offices available.
 Locations are given in 2D coordinates in [X, Y], where X and Y are integers.
 Euclidean distance is applied to find the distance between you and a post office.
 Assume your location is [m, n] and the location of a post office is [p, q], the Euclidean distance between the office and you is SquareRoot((m - p) * (m - p) + (n - q) * (n - q)).
 K is a positive integer much smaller than the given number of post offices. from aonecode.com

 e.g.
 Input
 you: [0, 0]
 post_offices: [[-16, 5], [-1, 2], [4, 3], [10, -2], [0, 3], [-5, -9]]
 k = 3

 Output from aonecode.com
 [[-1, 2], [0, 3], [4, 3]]

 **/