package dynamicprogramming.matrix;

import java.util.Arrays;

public class LC221_MaximalSquare {

    private int maxArea = Integer.MIN_VALUE;

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];

        for(int i =0; i < m; i++){

            Arrays.fill(memo[i], -1);
        }

        for(int i =0; i < m; i ++){

            for(int j = 0; j < n; j++){

                if(matrix[i][j]=='1'){

                    maxArea = Math.max(maxArea,solve(matrix,i,j,memo));
                }
            }
        }

        return maxArea * maxArea;
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
