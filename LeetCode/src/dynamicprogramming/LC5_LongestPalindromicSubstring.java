package dynamicprogramming;

/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * https://leetcode.com/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC5_LongestPalindromicSubstring {

    public String longestPalindrome(String s){

        int n = s.length();

        boolean[][] dp = new boolean[n][n];

        int row = 0;

        int col = 0;

        for(int i = 0; i < n; i++){

            dp[i][i] = true;
        }

        for(int i =0; i < n-1; i++){

            if(s.charAt(i)==s.charAt(i+1)){

                dp[i][i+1] = true;
                row = i;
                col = i +1;
            }
        }

        for(int diff = 2;  diff < n; diff ++){

            for( int i =0; i< n - diff; i++){

                int j = i + diff;

                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){

                    dp[i][j] = true;

                    row  = i;
                    col = j;
                }
            }
        }

        return s.substring(row, col + 1);
    }
}
