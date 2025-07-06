package bitmanipulation;

/**
 * Given two binary strings a and b, return their sum as a binary string.
 *
 *
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 *
 * Constraints:
 *
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 *
 * https://leetcode.com/problems/add-binary/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LC67_AddBinary {

    public String addBinary(String a, String b) {

        int p1 = a.length() - 1;
        int p2 = b.length() - 1;

        int carry = 0;

        StringBuilder output = new StringBuilder();

        while(p1 >=0 || p2 >= 0 || carry ==1){

            int bit1 = p1 >=0 ? a.charAt(p1--) - '0' : 0;
            int bit2 = p2 >=0 ? b.charAt(p2--) - '0' : 0;

            int sum = bit1 + bit2 + carry;

            output.append(sum % 2);
            carry = sum /2;
        }

        return output.reverse().toString();

    }
}
