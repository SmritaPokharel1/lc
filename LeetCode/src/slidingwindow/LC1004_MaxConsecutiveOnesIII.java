package slidingwindow;

/**
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * Example 2:
 *
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 *
 * https://leetcode.com/problems/max-consecutive-ones-iii/description/
 */
public class LC1004_MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {

        int left = 0;

        int max = 0;

        int tolerance = k;

        for(int right = 0; right < nums.length; right ++){

            if(nums[right]==0) tolerance --;

            while(tolerance <0){

                if(nums[left] == 0) {
                    tolerance ++;
                }

                left ++;
            }

            max  = Math.max(max, right - left + 1);
        }

        return max;
    }
}
