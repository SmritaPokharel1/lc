package dynamicprogramming.stock;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 *
 * Input: prices = [1]
 * Output: 0
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC309_BestTimeToBuyStockWithCooldown {

    public int maxProfitGreedy(int[] prices) {

        int sold = Integer.MIN_VALUE;
        int held = Integer.MIN_VALUE;
        int reset = 0;

        for(int price : prices){

            int preSold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }

        return Math.max(reset, sold);
    }

    private Map<String, Integer> memo = new HashMap<>();

    public int maxProfit(int[] prices, int day, int holding){

        if(day >= prices.length) return 0;

        String key = day +"-"+ holding;

        if(memo.containsKey(key)) return memo.get(key);

        int result = 0;

        if(holding==1){

            int sell = prices[day] + maxProfit(prices, day+2 , 0);

            int hold = maxProfit(prices,day +1 , 1);

            result = Math.max(sell,hold);

        }else{

            int buy = -prices[day] + maxProfit(prices, day +1, 1);

            int rest = maxProfit(prices, day + 1, 0);

            result = Math.max(buy, rest);

        }

        memo.put(key, result);

        return result;

    }
}
