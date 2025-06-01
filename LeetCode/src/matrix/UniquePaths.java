package matrix;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {

        int[][] memo = new int[m][n];

        return topdownWithMemo(0,0,m,n, memo);

        // return bottomUp(m,n);
    }

    private int topdownWithMemo(int i, int j, int m, int n, int[][] memo){

        if(i>=m  || j >= n) return 0;

        if(i==m-1 && j==n-1) return 1;

        if(memo[i][j] !=0) return memo[i][j];

        memo[i][j] = topdownWithMemo(i+1,j, m,n,memo) + topdownWithMemo(i, j+1, m,n,memo);

        return memo[i][j];
    }

    private int bottomupIncreasing(int m, int n){

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

    private int bottomupDecreasing(int m, int n){

        int[][] dp = new int[m+1][n+1];

        dp[m - 1][n - 1] = 1;

        for(int i =m-1; i>=0; i--){

            for(int j =n-1; j>=0; j--){

                if(i == m-1 && j == n-1) continue;

                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[0][0];
    }


}
