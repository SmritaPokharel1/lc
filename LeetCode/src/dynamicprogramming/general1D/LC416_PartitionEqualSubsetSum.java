package dynamicprogramming.general1D;

/**
 *
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * https://leetcode.com/problems/partition-equal-subset-sum/description/
 */
public class LC416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int n : nums) sum += n;

        int n = nums.length;

        if(sum % 2 == 1) return false; // odd sum and so cannot be partitioned into equal parts

        int targetSum = sum / 2;

        Boolean[][] memo = new Boolean[n][targetSum+1];

        return partition(nums, 0, targetSum,memo);
    }

    public boolean partition(int[] nums, int index, int targetSum,Boolean[][] memo){

        if(targetSum == 0) return true;

        if(index >= nums.length || targetSum < 0) return false;

        if(memo[index][targetSum]!=null) return memo[index][targetSum];

        boolean take = partition(nums, index+1, targetSum - nums[index], memo);

        boolean skip = partition(nums, index+1, targetSum, memo);

        memo[index][targetSum] = take || skip;

        return memo[index][targetSum];
    }
}
