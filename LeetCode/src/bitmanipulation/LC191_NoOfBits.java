package bitmanipulation;

/**
 * Given a positive integer n,
 * write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
 * https://leetcode.com/problems/number-of-1-bits/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LC191_NoOfBits {

    public int hammingWeight(int n) {

        int totalOnes = 0;

        int remainder = 0;

        while(n >0){

            remainder = n % 2;
            n = n /2;

            if(remainder == 1) totalOnes++;
        }

        return totalOnes;
    }
}
