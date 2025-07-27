package dynamicprogramming.finonacci;

import java.util.Arrays;


/**
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 3:
 *
 * Input: nums = [1,2,3]
 * Output: 3
 *
 * https://leetcode.com/problems/house-robber-ii/description/
 */
public class LC213_HouseRobberII {

    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];

        int n = nums.length;

        int[] memo1 = new int[n];
        int[] memo2 = new int[n];

        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);

        int includeFirst = rob(nums, 0, n-2, memo1);
        int includeLast = rob(nums, 1, n-1, memo2);

        return Math.max(includeFirst, includeLast);
    }

    public int rob(int[] nums, int index, int end, int[] memo){

        if(index > end) return 0;

        if(memo[index]!= -1) return memo[index];

        int take = nums[index] + rob(nums, index +2, end, memo);
        int skip = rob(nums, index +1, end, memo);

        memo[index] = Math.max(take,skip);

        return memo[index];
    }
}
