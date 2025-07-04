package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 * https://leetcode.com/problems/n-th-tribonacci-number/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC1137_TribonacciNumbers {

    Map<Integer,Integer> memo = new HashMap<>();

    public int tribonacci(int n) {

        memo.put(0,0);
        memo.put(1,1);
        memo.put(2,1);

        return solveByTopDown(n);
    }

    public int solveByTopDown(int n){

        if(memo.containsKey(n)) return memo.get(n);

        int answer = solveByTopDown(n-1) + solveByTopDown(n-2) + solveByTopDown(n-3);

        memo.put(n,answer);

        return answer;
    }

    public int solveByBottomup(int n){

        int[] dp = new int[n+1];

        if(n ==0) return 0;

        if(n==1 || n ==2) return 1;

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i =3; i<=n;i++){

            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        return dp[n];
    }
}
