package dynamicprogramming;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of
 * them is that adjacent houses have security systems connected
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 * https://leetcode.com/problems/house-robber?envType=study-plan-v2&envId=dynamic-programming
 *
 */
public class LC198_HouseRobber {

    public int rob(int[] nums) {

        int[] memo = new int[nums.length];

        return robBottomUp(nums);
    }

    public int robWithoutMemo(int[] nums, int index){

        if(index >= nums.length ) return 0;

        int take = nums[index] + robWithoutMemo(nums, index +2);

        int skip = robWithoutMemo(nums, index+1);

        return Math.max(take, skip);
    }

    public int robWithMemo(int[] nums, int index, int[] memo){

        if(index >= nums.length ) return 0;

        if(memo[index] != 0) return memo[index];

        int take = nums[index] + robWithMemo(nums, index +2, memo);

        int skip = robWithMemo(nums, index+1, memo);

        memo[index] = Math.max(take, skip);

        return memo[index];
    }

    public int robBottomUp(int[] nums){

        if(nums.length ==0) return 0;

        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length+2];

        for(int i = nums.length -1; i>=0; i--){

            dp[i] = Math.max(dp[i+2]+ nums[i], dp[i+1]);
        }

        return dp[0];
    }
}
