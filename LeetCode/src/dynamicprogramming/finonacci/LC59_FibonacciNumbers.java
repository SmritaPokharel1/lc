package dynamicprogramming.finonacci;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * https://leetcode.com/problems/fibonacci-number/?envType=study-plan-v2&envId=dynamic-programming
 *
 */
public class LC59_FibonacciNumbers {

        public int  fib(int n){

            int[] memo = new int[n+1];
            return bottomup(n);
        }

        public int fibWithoutMemo(int n){

            if(n==0) return 0;

            if(n==1) return 1;

            if(n==2) return 1;

            return fib(n-1) + fib(n-2);
        }

        public int fibWithMemo(int n, int[] memo){

            if(n==0) return 0;

            if(n == 1) return 1;

            if(n==2) return 1;

            if(memo[n]!=0) return memo[n];

            memo[n] = fibWithMemo(n-1, memo) + fibWithMemo(n-2, memo);

            return memo[n];
        }

        public int bottomup(int n){

            if(n==0) return 0;

            if(n==1) return 1;

            int[] dp = new int[n];

            dp[0] = 1;

            dp[1] = 1;

            for(int i =2; i<n; i++){

                dp[i] = dp[i-1] + dp[i-2];
            }

            return dp[n-1];
        }
}
