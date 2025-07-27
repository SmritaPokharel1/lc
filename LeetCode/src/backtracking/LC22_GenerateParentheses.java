package backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class LC22_GenerateParentheses {

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        backtrack(n, 0, 0, "");

        return result;
    }

    private void backtrack(int n, int open, int close, String current){

        if(current.length() == 2 * n){

            result.add(current);
            return;
        }

        if(open < n) backtrack(n, open+1, close, current + "(");

        if(close < open) backtrack(n, open, close+1, current + ")");
    }
}
