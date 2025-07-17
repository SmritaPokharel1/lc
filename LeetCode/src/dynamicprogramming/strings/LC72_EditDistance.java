package dynamicprogramming.strings;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 *
 * You have the following three operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 *
 * Example 1:
 *
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * Example 2:
 *
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 * https://leetcode.com/problems/edit-distance/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC72_EditDistance {

    private Integer memo[][];

    public int minDistance(String word1, String word2) {

        memo = new Integer[word1.length() + 1][word2.length() + 1];

        return minDistanceR(word1, word2, word1.length(), word2.length(), memo);
    }

    public int bottomup(String word1, String word2){

        int col = word1.length();

        int row = word2.length();

        int[][] dp = new int[row+1][col+1];

        for(int i = 0 ; i <= row; i++){

            dp[i][0] = i;
        }

        for(int j = 0; j <= col; j++){

            dp[0][j] = j;
        }

        for(int i = 1; i <= row; i++){

            for(int j = 1; j <= col; j++){

                if(word2.charAt(i-1)==word1.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{

                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                }
            }
        }

        return dp[row][col];
    }

    public int minDistanceR(String word1, String word2, int l1, int l2, Integer[][] memo){

        if(l1==0) return l2;

        if(l2==0) return l1;

        if(memo[l1][l2] != null) return memo[l1][l2];

        if(word1.charAt(l1-1)==word2.charAt(l2-1)) return minDistanceR(word1, word2, l1 -1, l2 - 1, memo);

        else{

            int insert = minDistanceR(word1, word2, l1, l2 -1, memo);

            int delete = minDistanceR(word1, word2, l1 - 1, l2, memo);

            int replace = minDistanceR(word1, word2, l1 - 1, l2 - 1, memo);

            memo[l1][l2] = Math.min(Math.min(insert, delete), replace) +1;

            return memo[l1][l2];
        }
    }
}
