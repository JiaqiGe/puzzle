// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
// How many possible unique paths are there?
//
//
// Above is a 3 x 7 grid. How many possible unique paths are there?
//
// Note: m and n will be at most 100.



// Follow up for "Unique Paths":
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// The total number of unique paths is 2.

public class UniquePath{
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        //initialize
        dp[rows-1][cols-1] = obstacleGrid[rows-1][cols-1] == 1 ? 0 : 1;

        // bottom row
        for(int j = cols-2; j >= 0; j--){
            dp[rows-1][j] = obstacleGrid[rows-1][j] == 1 ? 0 : dp[rows-1][j+1];
        }

        //left col
        for(int i = rows - 2; i >= 0; i--){
            dp[i][cols-1] = obstacleGrid[i][cols-1] == 1 ? 0 : dp[i+1][cols-1];
        }

        //dp
        for(int i = rows - 2; i >= 0; i--){
            for(int j = cols - 2; j >= 0; j--){
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : (dp[i][j+1] + dp[i+1][j]);
            }
        }

        return dp[0][0];
    }


    public int uniquePaths(int m, int n){
        //dp
        if(m <= 0 || n <= 0){
            return 0;
        }

        int[][] dp = new int[m][n];

        //initialize
        dp[m-1][n-1] = 1;

        for(int j = n - 2; j >= 0; j --){
            dp[m-1][j] = 1;
        }

        for(int i = m-2; i >= 0; i--){
            dp[i][n-1] = 1;
        }

        //dp
        for(int i = m-2; i >= 0; i--){
            for(int j = n-2; j >= 0; j--){
                dp[i][j] = dp[i][j+1] + dp[i+1][j];
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args){
        UniquePath u = new UniquePath();
        int m = 4;
        int n = 2;

        System.out.println(u.uniquePaths(m,n));

        int[][] obstacleGrid = new int[3][3];
        obstacleGrid[0] = new int[]{0,0,0};
        obstacleGrid[1] = new int[]{0,1,0};
        obstacleGrid[2] = new int[]{0,0,0};

        System.out.println(u.uniquePathsWithObstacles(obstacleGrid));

    }
}
