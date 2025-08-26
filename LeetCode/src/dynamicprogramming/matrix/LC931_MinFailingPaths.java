package dynamicprogramming.matrix;

import java.util.Arrays;


/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *
 * A falling path starts at any element in the first row and chooses the element in the next row that is either directly
 * below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1),
 * (row + 1, col), or (row + 1, col + 1).
 *
 * https://leetcode.com/problems/minimum-falling-path-sum/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC931_MinFailingPaths {

    public int minFallingPathSum(int[][] matrix) {

        int n = matrix.length;
        int minSum = Integer.MAX_VALUE;

        int[][] memo = new int[n][n];

        for(int i =0; i < n; i++){

            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }

        // Try starting from each cell in the first row
        for (int j = 0; j < n; j++) {
            minSum = Math.min(minSum, solve(matrix, 0, j, memo));
        }

        return minSum;

        // return bottomup(matrix);
    }

    public int solve(int[][] matrix, int i, int j, int[][] memo){

        int n = matrix.length;

        // Out of bounds, return a large value to avoid choosing this path
        if (j < 0 || j >= n) return Integer.MAX_VALUE;

        // Base case: last row
        if (i == n - 1) return matrix[i][j];

        if(memo[i][j]!= Integer.MAX_VALUE) return memo[i][j];

        // Recur to 3 possible moves: down-left, down, down-right
        int left = solve(matrix, i + 1, j - 1,memo);
        int down = solve(matrix, i + 1, j,memo);
        int right = solve(matrix, i + 1, j + 1,memo);

        memo[i][j]= matrix[i][j] + Math.min(Math.min(left, down), right);

        return memo[i][j];
    }

    public int bottomup(int[][] matrix){

        int m = matrix.length;

        int[][] dp = new int[m][m];

        for(int i = 0; i < m; i++){

            dp[m-1][i] = matrix[m-1][i];
        }

        for(int i = m-2; i >= 0; i--){

            for(int j =0; j < m; j++){

                int left = j >0 ? dp[i+1][j-1]: Integer.MAX_VALUE;
                int down = dp[i+1][j];
                int right = (j < m-1) ? dp[i+1][j+1] : Integer.MAX_VALUE;
                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(right, down));
            }
        }

        int min = Integer.MAX_VALUE;

        for(int j =0; j < m; j++){

            min = Math.min(min, dp[0][j]);
        }

        return min;
    }
}
