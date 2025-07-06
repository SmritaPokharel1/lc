package dynamicprogramming.subsequence;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.
 *
 * Note that:
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 * A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).
 *
 *
 * Example 1:
 *
 * Input: nums = [3,6,9,12]
 * Output: 4
 * Explanation:  The whole array is an arithmetic sequence with steps of length = 3.
 * Example 2:
 *
 * Input: nums = [9,4,7,2,10]
 * Output: 3
 * Explanation:  The longest arithmetic subsequence is [4,7,10].
 * Example 3:
 *
 * Input: nums = [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:  The longest arithmetic subsequence is [20,15,10,5].
 *
 * https://leetcode.com/problems/longest-arithmetic-subsequence/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC1027_LongestArithmeticSubsequence {

    public int longestArithSeqLength(int[] nums) {

        int max = Integer.MIN_VALUE;

        Map<Integer,Integer>[] dp = new HashMap[nums.length];

        for(int i = 0; i< nums.length; i++){

            dp[i] = new HashMap<>();

            for(int j = 0; j < i; j++){

                int diff = nums[i] - nums[j];

                int len = dp[j].getOrDefault(diff,1) +1;

                dp[i].put(diff, Math.max(dp[i].getOrDefault(diff,0),len));

                max = Math.max(max, len);

            }
        }

        return max;
    }
}
