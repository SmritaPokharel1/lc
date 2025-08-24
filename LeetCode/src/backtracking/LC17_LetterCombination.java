package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LC17_LetterCombination {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) return result;

        // Mapping digits to letters
        String[] mapping = {
                "",     // 0 (not used)
                "",     // 1 (not used)
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        solve(digits, result, 0, new StringBuilder(), mapping);
        return result;
    }

    public void solve(String digits,
                      List<String> result,
                      int index,
                      StringBuilder current,
                      String[] mappings) {

        if (current.length() == digits.length()) {

            result.add(current.toString());
            return;
        }

        String letters = mappings[Character.getNumericValue(digits.charAt(index))];

        for (char l : letters.toCharArray()) {

            current.append(l);

            solve(digits, result, index + 1, current, mappings);

            current.deleteCharAt(current.length() - 1);
        }
    }
}
