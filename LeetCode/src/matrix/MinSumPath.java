package matrix;

public class MinSumPath {

    public int minPathSum(int[][] grid) {

        int[][] memo = new int[grid.length][grid[0].length];

        return solve(grid,0,0,memo);
    }

    public int solve(int[][] grid, int i , int j, int[][] memo){

        int m = grid.length;
        int n = grid[0].length;

        if(i>= m || j >= n) return Integer.MAX_VALUE;

        if(i==m-1 && j == n-1) return grid[i][j];

        if(memo[i][j] !=0) return memo[i][j];

        memo[i][j] = grid[i][j] + Math.min( solve(grid, i+1, j, memo), solve(grid, i, j+1, memo));

        return memo[i][j];
    }
}
