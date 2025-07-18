package dynamicprogramming.stock;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LC123_BestTimeToBuyAndSellStockIII {

    private Map<String, Integer> memo = new HashMap<>();

    public int maxProfit(int[] prices) {

        return maxProfitTopDown(prices, 0, 2, 0);
    }

    public int maxProfitWithTwoArrays(int[] prices) {

        int n = prices.length;

        int[] left = new int[n];

        int[] right = new int[n];

        int min = prices[0];
        int max = prices[n-1];

        for(int i = 1; i < n; i++){

            min = Math.min(min, prices[i]);

            left[i] = Math.max(left[i-1], prices[i] - min);
        }

        for(int j = n-2; j >=0; j--){

            max = Math.max(max, prices[j]);

            right[j] = Math.max(right[j+1], max - prices[j]);
        }

        int maxProfit = 0;

        for(int i = 0; i <n ; i++){

            maxProfit = Math.max(maxProfit, right[i] + left[i]);
        }

        return maxProfit;
    }

    public int maxProfitTopDown(int[] prices, int day, int k, int hold){

        if(day >= prices.length || k == 0) return 0;

        String key = day +"-"+k+"-"+hold;

        if(memo.containsKey(key)) return memo.get(key);

        int doNothing = maxProfitTopDown(prices, day+1, k, hold);

        int doSomething = 0;

        if(hold == 1){

            doSomething = maxProfitTopDown(prices, day+1, k-1, 0) + prices[day];
        }

        if(hold == 0){

            doSomething = maxProfitTopDown(prices, day+1, k, 1) - prices[day];
        }

        memo.put(key, Math.max(doNothing, doSomething));

        return memo.get(key);
    }
}
