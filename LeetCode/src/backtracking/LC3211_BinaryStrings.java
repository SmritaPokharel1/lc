package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a positive integer n.
 *
 * A binary string x is valid if all substrings of x of length 2 contain at least one "1".
 *
 * Return all valid strings with length n, in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 *
 * Output: ["010","011","101","110","111"]
 *
 * Explanation:
 *
 * The valid strings of length 3 are: "010", "011", "101", "110", and "111".
 *
 *
 *
 * Example 2:
 *
 * Input: n = 1
 *
 * Output: ["0","1"]
 *
 * Explanation:
 *
 * The valid strings of length 1 are: "0" and "1".
 *
 * https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros
 *
 */
public class LC3211_BinaryStrings {

    public List<String> validStrings(int n) {

        List<String> result = new ArrayList();

        backtrack("", result, n);

        return result;
    }

    public void backtrack(String curr, List<String> result, int n){

        if(curr.length()==n) {

            result.add(curr);
            return;
        }

        if (curr.length() == 0 || curr.charAt(curr.length() - 1) != '0') backtrack(curr+"0",result,n);

        backtrack(curr+"1", result, n);
    }
}
