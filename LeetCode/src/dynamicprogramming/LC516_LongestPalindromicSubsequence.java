package dynamicprogramming;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC516_LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {

        int n = s.length();

        int[][] memo = new int[n][n];

        return solve(s,0,n-1,memo);

        // return bottomup(s);
    }

    public int solve(String s, int i, int j, int[][] memo){

        if(i  > j) return 0;

        if( i==j) return 1;

        if(memo[i][j] != 0) return memo[i][j];

        if(s.charAt(i) == s.charAt(j)){

            memo[i][j] = 2 + solve(s, i+1, j-1, memo);
        }else{

            memo[i][j] = Math.max(solve(s, i+1,j, memo), solve(s, i, j-1, memo));
        }

        return memo[i][j];


    }

    public int bottomup(String s){

        int n = s.length();

        int[][] dp = new int[n][n];

        for(int i =0; i<n; i++){

            dp[i][i] = 1;
        }

        for(int i = n-1; i >= 0; i--){

            for(int j = i+1; j < n ; j++){

                if(s.charAt(i)==s.charAt(j)){

                    dp[i][j] = dp[i+1][j-1] +2;
                }else{

                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}
