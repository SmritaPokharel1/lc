package climbstairs;

public class ClimbStairs {

    public int climbStairs(int n) {
        int[] memo = new int[n+1];

        return climbStairsBottomUp(n);
    }

    public  int climbStairsBottomUp(int n){

        int[] dp = new int[n];

        if(n==1) return 1;

        dp[0] = 1;
        dp[1] = 2;

        for(int i =2; i<n; i++){

            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }

    public int climbStairsMemoized(int n, int[] memo){

        if(n==0) return 0;

        if(n==1) return 1;

        if(n==2) return 2;

        if(memo[n]!=0) return memo[n];

        memo[n] = climbStairsMemoized(n-1,memo) + climbStairsMemoized(n-2, memo);

        return memo[n];
    }
}
