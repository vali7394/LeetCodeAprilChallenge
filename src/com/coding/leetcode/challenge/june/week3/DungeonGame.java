package com.coding.leetcode.challenge.june.week3;/*
  @created 6/21/20
  @Author ** - Meeravali Shaik
 */

public class DungeonGame {


    class MyCircularQueue {
        protected int capacity;
        protected int tailIndex;
        public int[] queue;

        public MyCircularQueue(int capacity) {
            this.queue = new int[capacity];
            this.tailIndex = 0;
            this.capacity = capacity;
        }

        public void enQueue(int value) {
            this.queue[this.tailIndex] = value;
            this.tailIndex = (this.tailIndex + 1) % this.capacity;
        }

        public int get(int index) {
            return this.queue[index % this.capacity];
        }
    }


    class Solution {
        int inf = Integer.MAX_VALUE;
        MyCircularQueue dp;
        int rows, cols;

        public int getMinHealth(int currCell, int nextRow, int nextCol) {
            if (nextRow < 0 || nextCol < 0)
                return inf;

            int index = cols * nextRow + nextCol;
            int nextCell = this.dp.get(index);
            // hero needs at least 1 point to survive
            return Math.max(1, nextCell - currCell);
        }

        public int calculateMinimumHP(int[][] dungeon) {
            this.rows = dungeon.length;
            this.cols = dungeon[0].length;
            this.dp = new MyCircularQueue(this.cols);

            int currCell, rightHealth, downHealth, nextHealth, minHealth;
            for (int row = 0; row < this.rows; ++row) {
                for (int col = 0; col < this.cols; ++col) {
                    currCell = dungeon[rows - row - 1][cols - col - 1];

                    rightHealth = getMinHealth(currCell, row, col - 1);
                    downHealth = getMinHealth(currCell, row - 1, col);
                    nextHealth = Math.min(rightHealth, downHealth);

                    if (nextHealth != inf) {
                        minHealth = nextHealth;
                    } else {
                        minHealth = currCell >= 0 ? 1 : 1 - currCell;
                    }
                    this.dp.enQueue(minHealth);
                }
            }

            // retrieve the last element in the queue
            return this.dp.get(this.cols - 1);
        }
    }
}


/**
 The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

 The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

 Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

 In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.



 Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

 For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.

 -2 (K)	-3	3
 -5	-10	1
 10	30	-5 (P)


 Note:

 The knight's health has no upper bound.
 Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 **/