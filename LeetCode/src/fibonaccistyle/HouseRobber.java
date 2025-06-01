package fibonaccistyle;

public class HouseRobber {

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
