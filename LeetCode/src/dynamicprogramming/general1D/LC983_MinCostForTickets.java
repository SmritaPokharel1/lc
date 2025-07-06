package dynamicprogramming.general1D;

/**
 * You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.
 *
 * Train tickets are sold in three different ways:
 *
 * a 1-day pass is sold for costs[0] dollars,
 * a 7-day pass is sold for costs[1] dollars, and
 * a 30-day pass is sold for costs[2] dollars.
 * The passes allow that many days of consecutive travel.
 *
 * For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
 * Return the minimum number of dollars you need to travel every day in the given list of days.
 *
 * https://leetcode.com/problems/minimum-cost-for-tickets/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC983_MinCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {

        int[] memo = new int[days.length];
        return minCostMemo(days, costs, 0, 0, memo);
    }

    public int minCostTickets(int[] days, int[] costs, int index, int daysCovered){

        if(index >= days.length) return 0;

        if(days[index] <= daysCovered) return minCostTickets(days, costs, index +1, daysCovered);

        int oneDayPass = minCostTickets(days,costs, index+1, days[index]) + costs[0];

        int sevenDayPass = minCostTickets(days,costs, index+1, days[index] + 6) + costs[1];

        int thirtyDayPass = minCostTickets(days,costs, index+1, days[index] +29) + costs[2];

        return Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
    }

    public int minCostMemo(int[] days, int[] costs, int index, int daysCovered, int[] memo){

        if (index >= days.length) return 0;

        if (days[index] <= daysCovered)
            return minCostMemo(days, costs, index + 1, daysCovered, memo);

        if (memo[index] != 0) return memo[index];

        int oneDayPass = minCostMemo(days, costs, index + 1, days[index], memo) + costs[0];
        int sevenDayPass = minCostMemo(days, costs, index + 1, days[index] + 6, memo) + costs[1];
        int thirtyDayPass = minCostMemo(days, costs, index + 1, days[index] + 29, memo) + costs[2];

        memo[index] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
        return memo[index];
    }
}
