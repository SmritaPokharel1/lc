package dynamicprogramming.matrix;


import java.util.Arrays;

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 *
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 *
 * https://leetcode.com/problems/unique-paths-ii/description/?envType=problem-list-v2&envId=matrix
 */
public class LC63_UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];

        // return bottomup(obstacleGrid);

        for(int i =0; i < obstacleGrid.length; i++){
            Arrays.fill(memo[i], -1);
        }

        return move(obstacleGrid, 0, 0, memo);
    }


    public int move(int[][] obstacleGrid, int i, int j, int[][] memo){

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(i >= m || i < 0 || j >= n || j < 0 || obstacleGrid[i][j]==1) return 0;

        if(memo[i][j] != -1) return memo[i][j];

        if(i == m-1 && j == n-1) return 1;

        int down = move(obstacleGrid, i, j+1, memo);
        int right = move(obstacleGrid, i+1, j, memo);

        memo[i][j] =  down + right;

        return memo[i][j];
    }

    public int bottomup(int[][] obstacleGrid){

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m+1][n+1];

        if(obstacleGrid[m-1][n-1] == 0) dp[m-1][n-1] = 1;

        for(int i = m-1; i >= 0 ; i--){

            for(int j = n-1; j >= 0; j--){

                if(obstacleGrid[i][j]==1) continue;

                if(i==m-1 && j == n-1) continue;

                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }
}
