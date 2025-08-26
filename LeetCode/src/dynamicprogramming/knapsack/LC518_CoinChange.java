package dynamicprogramming.knapsack;


/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * The answer is guaranteed to fit into a signed 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1,2,5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 *
 * https://leetcode.com/problems/coin-change-ii/description/
 *
 */
public class LC518_CoinChange {

    int change(int amount, int[] coins) {

        return topDownWithoutMemoization(amount, coins, 0);
    }

    int topDownWithoutMemoization(int amount, int[] coins, int index){

        if(amount == 0) return 1;

        if(amount < 0 || index >= coins.length) return 0;

        int skip = topDownWithoutMemoization(amount, coins, index+1);

        if(coins[index] > amount ) return skip;

        int include = topDownWithoutMemoization(amount-coins[index], coins, index);

        return include + skip;
    }

    int topDownWithMemoization(int amount, int[] coins, int index, int[][] memo){

        if(amount == 0 ) return 1;

        if(amount < 0 || index >= coins.length) return 0;

        if(memo[index][amount]!=0) return memo[index][amount];

        int skip = topDownWithMemoization(amount, coins, index+1, memo);

        if(coins[index] > amount ) return skip;

        int include = topDownWithMemoization(amount-coins[index], coins, index, memo);

        memo[index][amount] = include + skip;

        return memo[index][amount];
    }

    int bottomup(int amount, int[] coins){

        int n = coins.length;

        int[][] dp = new int[n+1][amount + 1];

        for(int i =0; i< n; i++){

            dp[i][0] = 1;
        }

        for(int i = 1; i<= n ; i++){

            int coin = coins[i-1];

            for(int j = 1; j<= amount; j++){

                if(coin> j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - coin];
                }
            }
        }

        return dp[n][amount];
    }

    public int coinChange(int[] coins, int amount, int start, Integer[][] memo){

        if(amount < 0) return 0;

        if(amount == 0) return 1;

        if(memo[start][amount] != null) return memo[start][amount];

        int ways = 0;

        for(int i = start; i < coins.length; i++){

            ways += coinChange(coins, amount - coins[i], i, memo);
        }

        memo[start][amount] = ways;

        return ways;
    }
}
