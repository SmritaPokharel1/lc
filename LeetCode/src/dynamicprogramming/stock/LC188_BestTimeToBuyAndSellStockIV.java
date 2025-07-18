package dynamicprogramming.stock;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.
 *
 * Find the maximum profit you can achieve. You may complete at most k transactions: i.e. you may buy at most k times and sell at most k times.
 *
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 *
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LC188_BestTimeToBuyAndSellStockIV {

    Map<String, Integer> memo = new HashMap<>();

    public int maxProfit(int k, int[] prices) {

        return maxProfit(prices, 0, k, 0);
    }

    public int maxProfit(int[] prices, int day, int k, int hold){

        if(day >= prices.length || k == 0) return 0;

        String key = day +"-" + k +"-"+hold;

        if(memo.containsKey(key)) return memo.get(key);

        int doNothing = maxProfit(prices, day+1, k, hold);

        int doSomething =0;

        if(hold==0){

            doSomething = maxProfit(prices, day+1, k, 1) - prices[day];
        }

        if(hold==1){

            doSomething = maxProfit(prices, day + 1, k - 1, 0) + prices[day];
        }

        int result = Math.max(doNothing, doSomething);

        memo.put(key, result);

        return memo.get(key);
    }
}
