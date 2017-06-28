// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.


public class MinimalSumPath{
    public int minPathSum(int[][] grid){
        //dp

        if(grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        //initialize
        dp[rows-1][cols-1] = grid[rows-1][cols-1];

        for(int j = cols - 2; j >= 0; j--){
            dp[rows-1][j] = grid[rows-1][j] + dp[rows-1][j+1];
        }

        for(int i = rows - 2; i >= 0; i--){
            dp[i][cols-1] = grid[i][cols-1] + dp[i+1][cols-1];
        }

        //dp

        for(int i = rows - 2; i >= 0; i--){
            for(int j = cols - 2; j >= 0; j--){
                dp[i][j] = Math.min(dp[i][j+1], dp[i+1][j]) + grid[i][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args){

    }
}
