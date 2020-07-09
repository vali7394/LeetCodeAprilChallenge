package com.coding.leetcode.challenge.june.week3;/*
  @created 6/17/20
  @Author ** - Meeravali Shaik
 */

public class SurroundedRegions {
    public void solve(char[][] board) {

        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length < 3) return;

        for(int i=0;i<board[0].length;i++){
            markBoarders(0,i,board);
            markBoarders(board.length-1,i,board);
        }

        for(int i=0;i<board[0].length;i++){
            markBoarders(i,0,board);
            markBoarders(i,board[0].length-1,board);
        }

        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[0].length;j++){
                if(board[i][j]=='0'){
                    board[i][j]='X';
                }
                else if(board[i][j]=='1'){
                    board[i][j]='X';
                }


            }
        }

    }

    private void markBoarders(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '1';
        markBoarders(i + 1, j, board);
        markBoarders(i - 1, j, board);
        markBoarders(i, j - 1, board);
        markBoarders(i, j + 1, board);
    }

    public static void main(String[] args) {
        SurroundedRegions regions = new SurroundedRegions();
       // char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'}};
        regions.solve(board);
        for (char[] row : board){
            for(char column : row){
             System.out.println(column);
            }
        }
    }

}


/**

 Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.

 Example:

 X X X X
 X O O X
 X X O X
 X O X X
 After running your function, the board should be:

 X X X X
 X X X X
 X X X X
 X O X X
 Explanation:

 Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
 Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 */