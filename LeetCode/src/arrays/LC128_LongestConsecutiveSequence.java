package arrays;

import java.util.Arrays;

/**
 * Given an unsorted list of integers arr, determine the length of the longest sequence of consecutive numbers.
 *
 * Your solution must run in O(n) time complexity.
 *
 * Example 1:
 *
 * Input:
 * arr = [10, 5, 12, 6, 11, 7]
 * Output: 4
 * Explanation: The longest consecutive sequence is [5, 6, 7, 8]. Therefore, the length is 4.
 *
 * Example 2:
 *
 * Input:
 * arr = [15, 3, 2, 1, 5, 4]
 * Output: 5
 * Explanation: The longest consecutive sequence is [1, 2, 3, 4, 5], so the length is 5.
 *
 * https://leetcode.com/problems/longest-consecutive-sequence/description/
 */
public class LC128_LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums.length==0 || nums.length == 1) return nums.length;

        Arrays.sort(nums);

        int max = 0;

        int count = 1;

        for(int i = 1; i < nums.length; i++){

            if(nums[i-1] == nums[i]) continue;

            if(nums[i-1]+1 == nums[i]) {

                count ++;
            }
            else{
                max = Math.max(max, count);
                count = 1;
            }
        }

        max = Math.max(max,count);

        return max;
    }
}
