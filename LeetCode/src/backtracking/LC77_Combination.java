package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 * https://leetcode.com/problems/combinations
 *
 */
public class LC77_Combination {

    private List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];

        for(int i =0; i < n; i++) nums[i] = i+1;

        backtrack(nums, 0, k, new ArrayList<>());

        return result;
    }

    public void backtrack(int[] nums, int start, int k, List<Integer> current){

        if(current.size() == k){

            result.add(new ArrayList<Integer>(current));
            return;
        }

        for(int i = start; i < nums.length; i++){

            current.add(nums[i]);
            backtrack(nums, i+1, k, current);
            current.remove(current.size() - 1);
        }
    }
}
