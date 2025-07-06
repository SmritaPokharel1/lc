package dynamicprogramming.matrix;

import java.util.List;

/**
 *
 * Given a triangle array, return the minimum path sum from top to bottom.
 *
 * For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row,
 * you may move to either index i or index i + 1 on the next row.
 *
 * https://leetcode.com/problems/triangle/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC120_Triangle {

    public int minimumTotal(List<List<Integer>> triangle){


        // int[][] memo = new int[size][triangle.get(size-1).size()];

        // for (int i = 0; i < size; i++) {
        //     memo[i] = new int[triangle.get(i).size()];
        //     Arrays.fill(memo[i], -1);
        // }

        return minTotalBottomUp(triangle);
    }

    public int minTotalBottomUp(List<List<Integer>> triangle){

        int m = triangle.size();
        int n = triangle.get(m-1).size();

        int[][] dp = new int[m+1][n+1];

        for(int i =0; i<n;i++){

            dp[m-1][i] = triangle.get(m-1).get(i);
        }

        for(int i = m-2; i>=0; i--){

            for(int j = 0; j < triangle.get(i).size(); j++){

                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }

    public int minTotalWithMemo(List<List<Integer>> triangle, int i, int j, int[][] memo){

        if( i >= triangle.size()) return 0;

        if( i== triangle.size() -1 && j >= triangle.get(i).size()) return 0;

        if(i== triangle.size() -1) return triangle.get(i).get(j);

        if(memo[i][j]!=-1) return memo[i][j];

        memo[i][j] = triangle.get(i).get(j) + Math.min(minTotalWithMemo(triangle, i+1, j, memo), minTotalWithMemo(triangle, i+1, j+1, memo));

        return memo[i][j];
    }

    public int minTotalWithoutMemo(List<List<Integer>> triangle, int i, int j){

        if(i >= triangle.size()) return 0;

        if(i == triangle.size() -1 && j > triangle.get(i).size()) return 0;

        if( i == triangle.size() -1) return triangle.get(i).get(j);

        return triangle.get(i).get(j) + Math.min(minTotalWithoutMemo(triangle, i+1, j), minTotalWithoutMemo(triangle, i+1, j+1));
    }
}
