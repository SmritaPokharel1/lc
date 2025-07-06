package dynamicprogramming.matrix;

import java.util.Arrays;

/**
 *
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 *
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 *
 * The test cases are generated so that the answer will be less than or equal to 2 * 109
 *
 * https://leetcode.com/problems/unique-paths/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC62_UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        for(int i =0; i<m; i++){

            for(int j =0; j<n; j++){

                memo[i][j] = -1;
            }
        }

        // return move(0,0,m,n, memo);

        // return bottomUp(m,n);

        // return uniquePathsWithoutMemo(0,0,m,n,memo);

        return bottomup(m,n);
    }

    public int uniquePathsWithoutMemo(int i, int j, int m, int n, int[][] memo){

        if(i >= m || j >= n) return 0;

        if(i==m-1 && j == n-1) return 1;

        if(memo[i][j]!=-1) return memo[i][j];

        int right = uniquePathsWithoutMemo(i+1, j, m, n, memo);

        int left =  uniquePathsWithoutMemo(i, j+1, m, n, memo);

        memo[i][j] = right + left;

        return memo[i][j];
    }

    private int bottomup (int m, int n){

        int[][] dp = new int[m][n];

        for(int[] arr : dp){

            Arrays.fill(arr,1);
        }

        for(int i =1; i<m; i++){

            for(int j =1; j<n; j++){

                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

}
