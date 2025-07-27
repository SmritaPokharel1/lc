package dynamicprogramming;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 * https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LC55_JumpGame {

    public boolean canJump(int[] nums) {

        // Boolean[] memo = new Boolean[nums.length];

        // return canJump(nums,0,memo);

        return bottomup(nums);
    }

    public boolean bottomup(int[] nums){

        int n = nums.length;

        boolean[] dp = new boolean[n];

        dp[n-1] = true;

        for(int i = n-2; i >= 0 ; i--){

            int maxJump = nums[i];

            for (int j = 1; j <= maxJump && (i + j) < n; j++) {

                if (dp[i + j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }


    public boolean canJump(int[] nums, int index, Boolean[] memo){

        if(index >= nums.length) return false;

        if(index == nums.length -1 ) return true;

        if(memo[index]!=null) return memo[index];

        boolean canReach = false;

        int maxJump = nums[index];

        for (int next = 1; next <= maxJump; next++) {

            boolean temp = canJump(nums, index+next,memo);

            if(temp) canReach = true;
        }

        memo[index] = canReach;

        return memo[index];
    }
}
