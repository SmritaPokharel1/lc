package dynamicprogramming.subsequence;

/**
 * You are given two integer arrays nums1 and nums2. We write the integers of nums1 and nums2 (in the order they are given) on two separate horizontal lines.
 *
 * We may draw connecting lines: a straight line connecting two numbers nums1[i] and nums2[j] such that:
 *
 * nums1[i] == nums2[j], and
 * the line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting line cannot intersect even at the endpoints (i.e., each number can only belong to one connecting line).
 *
 * Return the maximum number of connecting lines we can draw in this way.
 *
 * https://leetcode.com/problems/uncrossed-lines/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC1035_UncrossedLines {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {

        int n1 = nums1.length;

        int n2 = nums2.length;

        int[][] dp = new int[n1+1][n2+1];

        for(int i = 1; i <= n1; i++){

            for(int j = 1; j <= n2; j++){

                if(nums1[i-1] == nums2[j-1]){

                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{

                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n1][n2];
    }
}
