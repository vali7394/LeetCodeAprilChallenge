package com.coding.leetcode.amazon;/*
  @created 6/17/20
  @Author ** - Meeravali Shaik
 */
import java.util.Arrays;
public class MoviesOnFlight {

    public static int[] selectMovies(int[] input, int d){
        int[] result = new int[2];
        d = d-30;
        Arrays.sort(input);

        int left = 0;
        int right = input.length-1;
        int maxSofar = Integer.MIN_VALUE;
        while (left<=right){
            int sum = input[left]+input[right];
            if(sum>d){
                right--;
            }else {
                if(sum>maxSofar){
                    result = new int[]{input[left], input[right]};
                    maxSofar = sum;
                }
                left++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] movies = {90, 85, 75, 60, 120, 150, 125};
        for(int i : selectMovies(movies,250)){
            System.out.println(i);
        }
    }

}


/**

 You are on a flight and wanna watch two movies during this flight.
 You are given int[] movie_duration which includes all the movie durations.
 You are also given the duration of the flight which is d in minutes.
 Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).
 Find the pair of movies with the longest total duration. If multiple found, return the pair with the longest movie.

 e.g.
 Input
 movie_duration: [90, 85, 75, 60, 120, 150, 125]
 d: 250

 Output from aonecode.com
 [90, 125]
 90min + 125min = 215 is the maximum number within 220 (250min - 30min)

 */