// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
//
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// For example,
// There exist two distinct solutions to the 4-queens puzzle:
// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],
//
//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
import java.util.*;

public class NQueens{

    public int totalNQueens(int n){
        if(n <= 0){
            return 0;
        }

        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        return totalNQueensHelp(board, 0);
    }

    private int totalNQueensHelp(char[][] board, int i){
        //dfs
        if(i >= board.length){
            return 1;
        }
        int total = 0;

        for(int j = 0; j < board.length; j++){
            if(board[i][j] == '.'){
                board[i][j] = 'Q';
                if(isValid(board, i, j)){
                    total += totalNQueensHelp(board, i+1);
                }
                board[i][j] = '.';
            }
        }

        return total;
    }


    public List<List<String>> solveNQueens(int n) {
        if(n <= 0){
            return new ArrayList<>();
        }
        //dfs

        //initial board
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        //recursive dfs
        List<char[]> solution = new ArrayList<>();
        List<List<String>> solutions = new ArrayList<>();

        solveNQueensHelp(board, 0, solutions, solution);
        return solutions;
   }

   private void solveNQueensHelp(char[][] board, int n, List<List<String>> solutions, List<char[]> solution){
       if(n >= board.length){
           List<String> oneSolution = new ArrayList<>();
           for(char[] charArray : solution){
               oneSolution.add(new String(charArray));
           }
           solutions.add(oneSolution);
           return;
       }

       //revursive function
       // for each row, we place one and only one queen
       for(int j = 0; j < board[0].length; j++){
           if(board[n][j] == '.'){
               board[n][j] = 'Q';
               if(isValid(board, n, j)){
                   solution.add(board[n]);
                   solveNQueensHelp(board, n+1, solutions, solution);
                   solution.remove(solution.size()-1);
               }
               board[n][j] = '.';
           }
       }

       return;
   }

   private  boolean isValid(char[][] board, int row, int col){
       int rows = board.length;
       int cols = board[0].length;
       //check row
       int count = 0;
       for(int j = 0; j < cols; j++){
           if(board[row][j] == 'Q'){
               count ++;
           }
       }

       if(count > 1){
           return false;
       }

       //check column
       count = 0;
       for(int i = 0; i < rows; i++){
           if(board[i][col] == 'Q'){
               count ++;
           }
       }

       if(count > 1){
           return false;
       }

       //check diagnost
       count = 0;
       int i = row;
       int j = col;

       while(--i >=0 && --j >= 0){
           if(board[i][j] == 'Q'){
               count ++;
           }
       }

       i = row;
       j = col;

       while(++i < rows && ++j < cols){
           if(board[i][j] == 'Q'){
               count ++;
           }
       }

       if(count > 0){
           return false;
       }

       //check anti-diagnost
       count = 0;

       i = row;
       j = col;

       while(--i >= 0 && ++j < cols){
           if(board[i][j] == 'Q'){
               count ++;
           }
       }

       i = row;
       j = col;

       while(++i < rows && --j >= 0){
           if(board[i][j] == 'Q'){
               count ++;
           }
       }

       if(count > 0){
           return false;
       }

       return true;
   }

   public static void main(String[] args){
       NQueens q = new NQueens();
       int n = 4;
       List<List<String>> solutions = q.solveNQueens(n);

       for(List<String> oneSolution : solutions){
           for(String str : oneSolution){
               System.out.println(str);
           }
           System.out.println();
       }

       System.out.println("total soluton: "+q.totalNQueens(n));
   }
}
