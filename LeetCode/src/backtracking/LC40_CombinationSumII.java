package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * https://leetcode.com/problems/combination-sum-ii/description/?envType=problem-list-v2&envId=backtracking
 */
public class LC40_CombinationSumII {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int target,  int start, List<Integer> current){

        if(target == 0){

            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < nums.length; i++){

            if(i > start && nums[i]==nums[i-1]) continue;

            if(nums[i] > target) return;

            current.add(nums[i]);

            backtrack(nums, target - nums[i],  i+1, current);

            current.remove(current.size() - 1);

        }
    }
}
