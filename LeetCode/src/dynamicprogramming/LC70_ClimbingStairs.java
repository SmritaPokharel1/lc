package dynamicprogramming;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * https://leetcode.com/problems/climbing-stairs/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC70_ClimbingStairs {

    public int climbStairs(int n) {
//        int[] memo = new int[n+1];
        return climbStairsBottomUp(n);
    }

    public int climbStairsWithoutMemo(int n){

        if(n==0) return 0;

        if(n==1) return 1;

        if(n==2) return 2;

        return climbStairsWithoutMemo(n-1) + climbStairsWithoutMemo(n-2);
    }

    public int climbStairsWithMemo(int n, int[] memo){

        if(n==0) return 0;

        if(n==1) return 1;

        if(n==2) return 2;

        if(memo[n]!=0) return memo[n];

        int ans = climbStairsWithMemo(n-1, memo) + climbStairsWithMemo(n-2, memo);

        memo[n] = ans;

        return memo[n];

    }

    public int climbStairsBottomUp(int n){

        if(n==1) return 1;

        int[] dp = new int[n];

        dp[0] = 1;

        dp[1] = 2;

        for(int i =2; i<n; i++){

            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }

}
