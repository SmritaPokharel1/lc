package bitmanipulation;

/**
 * Given an integer num, return a string of its base 7 representation.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 100
 * Output: "202"
 * Example 2:
 *
 * Input: num = -7
 * Output: "-10"
 *
 *
 * Constraints:
 *
 * -107 <= num <= 107
 *
 * https://leetcode.com/problems/base-7/description/
 */
public class LC504_Base7 {

    public String convertToBase7(int num) {

        if (num == 0) return "0";

        StringBuilder result = new StringBuilder();

        boolean isNegative = num < 0;

        int n = Math.abs(num);

        while (n > 0) {

            int remainder = n % 7;
            n = n / 7;

            result.append(remainder);
        }

        if (isNegative) result.append("-");

        return result.reverse().toString();

    }

}
