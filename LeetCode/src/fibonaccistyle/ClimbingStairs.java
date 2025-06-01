package fibonaccistyle;

public class ClimbingStairs {

    public int climbStairs(int n) {
//        int[] memo = new int[n+1];
        return climbStairsBottomUp(n);
    }

    public int climbStairsWithoutMemo(int n){

        if(n==0) return 0;

        if(n==1) return 1;

        if(n==2) return 2;

        return climbStairsWithoutMemo(n-1) + climbStairsWithoutMemo(n-2);
    }

    public int climbStairsWithMemo(int n, int[] memo){

        if(n==0) return 0;

        if(n==1) return 1;

        if(n==2) return 2;

        if(memo[n]!=0) return memo[n];

        int ans = climbStairsWithMemo(n-1, memo) + climbStairsWithMemo(n-2, memo);

        memo[n] = ans;

        return memo[n];

    }

    public int climbStairsBottomUp(int n){

        if(n==1) return 1;

        int[] dp = new int[n];

        dp[0] = 1;

        dp[1] = 2;

        for(int i =2; i<n; i++){

            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n-1];
    }

}
