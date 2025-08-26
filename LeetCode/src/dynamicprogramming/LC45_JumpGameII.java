package dynamicprogramming;

import java.util.Arrays;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 * https://leetcode.com/problems/jump-game-ii/description/
 */
public class LC45_JumpGameII {

    public int jump(int[] nums) {

        Integer[] memo = new Integer[nums.length];

        Arrays.fill(memo, -1);

        return canJump(nums, 0, memo);
    }

    public int canJump(int[] nums, int index, Integer[] memo){

        if(index >= nums.length) return Integer.MAX_VALUE;

        if(index == nums.length - 1) return 0;

        if(memo[index] != -1) return memo[index];

        int maxJump = nums[index];

        int minJumps = Integer.MAX_VALUE;

        for(int i = index + 1; i <= index + maxJump; i++){

            if(i > nums.length) break;

            int jumpsFromNext = canJump(nums, i, memo);

            if(jumpsFromNext != Integer.MAX_VALUE){

                minJumps = Math.min(minJumps, jumpsFromNext + 1);
            }
        }

        memo[index] = minJumps;

        return minJumps;
    }
}
