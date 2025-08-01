package math;

/**
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Example 1:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 * https://leetcode.com/problems/powx-n/description/
 */
public class LC50_Pow {

    public double myPow(double x, int n) {

        if(n < 0){
            x = 1/x;
        }
        return fastPow(x,n);

    }

    public double fastPow(double x, int n){

        if(n==0) return 1;

        double half = fastPow(x, n/2);

        if(n % 2 ==0) return half * half;

        return x * half * half;
    }

}
