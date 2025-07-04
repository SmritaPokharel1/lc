package dynamicprogramming;

/**
 *
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *
 * You can either start from the step with index 0, or the step with index 1.
 *
 * Return the minimum cost to reach the top of the floor.
 *
 *
 *
 * Example 1:
 *
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 *
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 *
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC746_MinCostClimingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int[] memo = new int[cost.length];

        // return Math.min(withoutMemo(cost, 0,memo), withoutMemo(cost,1,memo));

        return bottomup(cost);
    }

    public int bottomup(int[] cost){

        int n = cost.length;

        int[] dp = new int[n+2];

        for(int i =n -1; i>=0; i--){

            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0],dp[1]);
    }

    public int withMemo(int[] cost, int index, int[] memo){

        if(index>= cost.length) return 0;

        if(memo[index]!=0) return memo[index];

        memo[index] = cost[index] + Math.min(withMemo(cost, index+1,memo) , withMemo(cost, index+2,memo));

        return memo[index];
    }
}
