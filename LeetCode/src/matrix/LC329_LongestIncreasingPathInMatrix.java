package matrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/?envType=problem-list-v2&envId=matrix
 */
public class LC329_LongestIncreasingPathInMatrix {

    private Map<Integer, List<Integer>> map = new HashMap();

    private int max = 0;

    public int longestIncreasingPath(int[][] matrix) {

        int[][] memo = new int[matrix.length][matrix[0].length];

        for(int i =0; i< matrix.length; i++){

            for(int j = 0; j< matrix[0].length; j++){

                int sum = dfs(matrix, i, j, memo);
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int[][] memo){

        int m = matrix.length;
        int n = matrix[0].length;

        if(i < 0 || i >= m || j < 0 || j>= n) return 0;

        if(memo[i][j]!=0) return memo[i][j];

        int max = 1;
        if(i-1 >= 0 && matrix[i-1][j]> matrix[i][j]) max = Math.max(max, 1 + dfs(matrix, i-1, j, memo));
        if(j-1>=0 && matrix[i][j-1] > matrix[i][j]) max = Math.max(max, 1 + dfs(matrix, i, j-1, memo));
        if(i+1 <m && matrix[i+1][j] > matrix[i][j]) max = Math.max(max, 1 + dfs(matrix, i+1, j, memo));
        if(j+1 <n && matrix[i][j+1] > matrix[i][j]) max = Math.max(max, 1+ dfs(matrix, i, j+1, memo));

        memo[i][j] = max;
        return max;
    }
}
