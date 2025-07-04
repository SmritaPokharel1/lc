package dynamicprogramming;

/**
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * As shown below, there are 3 ways you can generate "rabbit" from s.
 * rabbbit
 * rabbbit
 * rabbbit
 * Example 2:
 *
 * Input: s = "babgbag", t = "bag"
 * Output: 5
 * Explanation:
 * As shown below, there are 5 ways you can generate "bag" from s.
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 * babgbag
 *
 * https://leetcode.com/problems/distinct-subsequences/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC115_DistinctSubsequence {

    public int numDistinct(String s, String t) {

        // int[][] memo = new int[s.length()][t.length()];
        // return recurse(s,t,0,0,memo);

        return bottomup(s,t);
    }

    public int recurse(String s, String t , int i, int j, int[][] memo){

        if(i==s.length() || j == t.length()) return j == t.length() ? 1:0;

        if(memo[i][j] != 0) return memo[i][j];

        if(s.charAt(i) == t.charAt(j)){

            memo[i][j] =  recurse(s, t, i+1, j,memo) + recurse(s,t, i+1, j+1,memo);
        }

        else {

            memo[i][j] = recurse(s, t, i+1, j,memo);
        }

        return memo[i][j];
    }


    public int bottomup(String s, String t ){

        int M = s.length();
        int N = t.length();

        int[][] dp = new int[M+1][N+1];

        for(int j =0; j <=N; j++){

            dp[M][j] = 0;
        }

        for(int i =0; i <= M; i++){

            dp[i][N] = 1;
        }

        for (int i = M -1; i>=0; i--){

            for(int j = N -1; j >= 0; j--){

                dp[i][j] = dp[i+1][j];

                if(s.charAt(i) == t.charAt(j)){

                    dp[i][j] += dp[i+1][j+1];
                }
            }
        }

        return dp[0][0];
    }
}
