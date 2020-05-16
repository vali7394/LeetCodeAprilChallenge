package com.coding.leetcode.challenge.May.week2;/*
  @created 5/8/20
  @Author - Meeravali Shaik
 */

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 */
public class CheckStraightLine {


    public static void main(String[] args) {
        int[][] inputOne = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        int[][] inputTwo = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(checkStraightLine(inputOne));
        System.out.println(checkStraightLine(inputTwo));
    }

    public static boolean checkStraightLine(int[][] coordinates) {

        int length = coordinates.length;
        if(length<=2){
            return true;
        }
        int diffBetweenPoint = coordinates[0][1]-coordinates[0][0];
        int diffBetweenXCoordinates = coordinates[1][0]-coordinates[0][0];
        int diffBetweenYCoordinates = coordinates[1][1]-coordinates[0][1];
        int i=1;
        while (i<length-1){
            if(diffBetweenPoint!=coordinates[i][1]-coordinates[i][0]){
                return false;
            }
            if(diffBetweenXCoordinates!=coordinates[i+1][0]-coordinates[i][0]){
                return false;
            }
            if(diffBetweenYCoordinates!=coordinates[i+1][1]-coordinates[i][1]){
                return false;
            }
            i++;

        }

        return true;

    }


}
