package dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 * https://leetcode.com/problems/perfect-squares/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC279_PerfectSquares {

    public int numSquares(int n) {

        List<Integer> squares = getSquareNums(n);

        int[] memo = new int[n+1];

        if(isPerfectSquare(n,squares)) return 1;

        return minPath(n, squares, memo);
    }

    private boolean isPerfectSquare(int n, List<Integer> squares){

        for(int square : squares){

            if(n == square) return true;
        }

        return false;
    }


    private int minPath(int amount, List<Integer> squares, int[] memo){

        if(amount == 0 || amount ==1) return amount;

        if(amount < 0) return Integer.MAX_VALUE;

        int min = Integer.MAX_VALUE;

        if(memo[amount] !=0) return memo[amount];

        for(int square : squares){

            int result = minPath(amount - square, squares, memo);

            if(result != Integer.MAX_VALUE){

                min = Math.min(min, result +1);
                memo[amount] = min;
            }
        }

        return min;
    }

    List<Integer> getSquareNums(int n){

        List<Integer> squares = new ArrayList<Integer>();

        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }

        return squares;

    }
}
