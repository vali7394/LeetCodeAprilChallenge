package com.coding.leetcode.amazon.sorting;/*
  @created 6/26/20
  @Author ** - Meeravali Shaik
 */
import java.util.Arrays;
import java.util.Comparator;

public class BurstBalloons {

    public static int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0){
            return 0;
        }
        if(points.length==1){
            return 1;
        }

        Arrays.sort(points, Comparator.comparing(i1->i1[1]));
        int totalArrows = 1;
        int[] currBallons = points[0];

        for(int i=1; i<points.length;i++){
            int[] temp = points[i];
            if(!(temp[0]<=currBallons[1]&& currBallons[1]<=temp[1])){
                totalArrows++;
                currBallons= temp;
            }
        }
        return totalArrows;
    }

    public static void main(String[] args) {
            int[][] input = new int[][] {{10,16}, {2,8}, {1,6}, {7,12}};
            System.out.println(findMinArrowShots(input));
    }

}


/**
 There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.

 An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

 Example:

 Input:
 [[10,16], [2,8], [1,6], [7,12]]

 Output:
 2

 Explanation:
 One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 **/