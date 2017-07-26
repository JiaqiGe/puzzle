// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
// For example,
// X X X X
// X O O X
// X X O X
// X O X X
// After running your function, the board should be:
//
// X X X X
// X X X X
// X X X X
// X O X X

import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class SurroundedRegion {
    public void solve(char[][] board){
    }

    private void dfs(char[][] board){
        if ((board.length == 0) || (board[0].length == 0)){
            return;
        }
        // dfs
        int row = board.length;
        int col = board[0].length;


        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'O'){
                    helpSolveDFS(board, i, j);
                }
            }
        }
    }

    private void bfs(char[][] board){
        if ((board.length == 0) || (board[0].length == 0)){
            return;
        }
        // dfs
        int row = board.length;
        int col = board[0].length;


        for(int i = 0; i < row; i++){
          if(board[i][0] == 'O'){
            helpSolveBFS(board, i, 0);
          }
          if(board[i][col-1] == 'O'){
            helpSolveBFS(board, i, col - 1);
          }
        }

        for(int j = 0; j < col; j++){
          if(board[0][j] == 'O'){
            helpSolveBFS(board, 0, j);
          }
          if(board[row-1][j] == 'O'){
            helpSolveBFS(board, row-1, j);
          }
        }

        for(int i = 0; i < row; i++){
          for(int j = 0; j < col; j++){
            if(board[i][j] == 'O'){
              board[i][j] = 'X';
            }else if(board[i][j] == 'W'){
              board[i][j] = 'O';
            }
          }
        }
        return;
    }

    private void helpSolveBFS(char[][] board, int i, int j){
        Queue<Pair> queue = new LinkedList<>();
        Pair         pair  = new Pair(i, j);
        queue.offer(pair);

        while (!queue.isEmpty()){
            Pair p = queue.poll();
            int  x = p.x;
            int  y = p.y;

            board[x][y] = 'W';
            if ((x + 1 < board.length) && (board[x + 1][y] == 'O')){
                queue.offer(new Pair(x + 1, y));
            }

            if ((x - 1 >= 0) && (board[x - 1][y] == 'O')){
                queue.offer(new Pair(x - 1, y));
            }


            if ((y + 1 < board[0].length) && (board[x][y + 1] == 'O')){
                queue.offer(new Pair(x, y + 1));
            }

            if ((y - 1 >= 0) && (board[x][y - 1] == 'O')){
                queue.offer(new Pair(x, y - 1));
            }
        }
    }

    private boolean helpSolveDFS(char[][] board, int i, int j){
        int row = board.length;
        int col = board[0].length;

        if ((i < 0) || (i >= row) || (j < 0) || (j >= col)){
            return false;
        }

        if (board[i][j] == 'X'){
            return true;
        }

        // board[i][j] == 'O'
        board[i][j] = 'X';
        boolean result = true;

        result = result && helpSolveDFS(board, i - 1, j);
        result = result && helpSolveDFS(board, i + 1, j);
        result = result && helpSolveDFS(board, i, j - 1);
        result = result && helpSolveDFS(board, i, j + 1);

        if (!result){
            board[i][j] = 'O';
        }

        return result;
    }

    public static void main(String[] args){
        char[][] board = new char[4][4];
        board[0] = new char[] { 'X', 'X', 'X', 'X' };
        board[1] = new char[] { 'X', 'O', 'O', 'X' };
        board[2] = new char[] { 'X', 'X', 'O', 'X' };
        board[3] = new char[] { 'X', 'O', 'X', 'X' };

        SurroundedRegion s = new SurroundedRegion();
        s.bfs(board);

        for (char[] a : board){
            for (char c : a){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
