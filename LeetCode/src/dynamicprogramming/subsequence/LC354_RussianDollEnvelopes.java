package dynamicprogramming.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 *
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 *
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 *
 * Note: You cannot rotate an envelope.
 *
 *
 *
 * Example 1:
 *
 * Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * Example 2:
 *
 * Input: envelopes = [[1,1],[1,1],[1,1]]
 * Output: 1
 *
 * https://leetcode.com/problems/russian-doll-envelopes/description/?envType=study-plan-v2&envId=dynamic-programming
 */
public class LC354_RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }

        List<Integer> lis = new ArrayList<>();

        for (int height : heights) {

            int left = 0, right = lis.size();

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (lis.get(mid) < height) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == lis.size()) {
                lis.add(height);
            } else {
                lis.set(left, height);
            }
        }

        return lis.size();
    }
}
