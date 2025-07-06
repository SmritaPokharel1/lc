package dynamicprogramming.matrix;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * https://leetcode.com/problems/minimum-path-sum/description/?envType=problem-list-v2&envId=matrix
 */
public class LC64_MinSumPath {

    public int minPathSum(int[][] grid) {

        int[][] memo = new int[grid.length][grid[0].length];

        return bottomup(grid);
    }

    int solve(int[][] grid, int i, int j){

        int m = grid.length;

        int n = grid[0].length;

        if(i>= m || j >= n) return Integer.MAX_VALUE;

        if(i==m-1 && j == n-1) return grid[i][j];

        return grid[i][j] + Math.min(solve(grid,i+1,j),solve(grid, i, j+1));
    }

    public int solveWithMemo(int[][] grid, int i, int j, int[][] memo){

        int m = grid.length;
        int n = grid[0].length;

        if(i >= m || j >= n) return Integer.MAX_VALUE;

        if(i==m-1 && j == n-1) return grid[i][j];

        if(memo[i][j]!=0) return memo[i][j];

        memo[i][j] = grid[i][j] + Math.min(solveWithMemo(grid, i+1, j, memo), solveWithMemo(grid, i, j+1, memo));

        return memo[i][j];
    }

    public int bottomup(int[][]grid){

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m+1][n+1];

        dp[m-1][n-1] = grid[m-1][n-1];

        // Initialize extra row and column to "infinity" so they don't affect min()
        for (int i = 0; i <= m; i++) dp[i][n] = Integer.MAX_VALUE;
        for (int j = 0; j <= n; j++) dp[m][j] = Integer.MAX_VALUE;

        for(int i =m-1; i >= 0; i--){

            for(int j = n-1; j>=0; j--){

                if(i==m-1 && j == n-1) continue;

                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }

        return dp[0][0];
    }

}
