package fibonaccistyle;

public class HouseRobber {

    private int[] memo;

    public int rob(int[] nums) {

        int N = nums.length;

        if(N == 0) return 0;

        int[] maxRobbed = new int[nums.length +1];

        maxRobbed[N] = 0;
        maxRobbed[N-1] = nums[N-1];

        for(int i = N-2; i>=0; --i){

            maxRobbed[i] = Math.max(maxRobbed[i+1], maxRobbed[i+2] + nums[i]);
        }

        return maxRobbed[0];
    }
}
