package dynamicprogramming.matrix;

import java.util.Arrays;

/**
 * Given an m x n binary matrix filled with 0's and 1's,
 * find the largest square containing only 1's and return its area.
 *
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 *
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 *
 *
 * Input: matrix = [["0"]]
 * Output: 0
 *
 * https://leetcode.com/problems/maximal-square/description/
 *
 */
public class LC221_MaximalSquare {

    public int bottomup(char[][] matrix){

        int m = matrix.length;
        int n = matrix[0].length;

        int maxSide = 0;

        int[][] dp = new int[m][n];

        for(int i = m-1; i >= 0; i--){

            for(int j = n-1; j >=0; j--){

                if(matrix[i][j] == '1'){

                    int right = (j+1 < n) ? dp[i][j+1] : 0;
                    int down = (i+1 < m) ? dp[i+1][j] : 0;
                    int diag = (i+1 < m && j+1 < n) ? dp[i+1][j+1] : 0;

                    dp[i][j] = 1 + Math.min(right, Math.min(down,diag));

                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

    public int solve(char[][] matrix, int row, int col, int[][] memo){

        int m = matrix.length;
        int n = matrix[0].length;

        if(row >= m || col >= n || matrix[row][col]=='0') return 0;

        if(memo[row][col] != -1) return memo[row][col];

        if(row == m-1 && col == n-1) return 1;

        int right = solve(matrix, row, col+1,memo);
        int diag = solve(matrix, row+1, col+1,memo);
        int down = solve(matrix, row+1, col,memo);

        memo[row][col] = 1 + Math.min(right , Math.min( diag , down));

        return memo[row][col];
    }
}
