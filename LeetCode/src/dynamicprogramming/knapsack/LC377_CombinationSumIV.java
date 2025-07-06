package dynamicprogramming.knapsack;

/**
 *
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 * Example 2:
 *
 * Input: nums = [9], target = 3
 * Output: 0
 *
 * https://leetcode.com/problems/combination-sum-iv/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC377_CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {

        int[] memo = new int[target + 1];

        // return combinationSum4(nums, target,memo);

        return bottomup(nums, target);
    }

    //Runs out of time but keeping it here to understand bottom up better
    public int combinationSum4(int[] nums, int target, int[] memo){

        if( target == 0) return 1;

        if(target < 0 ) return 0;

        if(memo[target] !=0) return memo[target];

        int count = 0;

        for(int num : nums){

            count += combinationSum4(nums, target - num, memo);
        }

        memo[target] = count;

        return count;
    }

    public int bottomup(int[] nums, int target){

        int[] dp = new int[target + 1];

        dp[0] = 1;

        for(int i =1; i<= target; i++){

            for(int num : nums){

                int index = i - num;

                if(index >= 0){
                    dp[i] += dp[index];
                }
            }
        }
        return dp[target];
    }
}
