package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 * https://leetcode.com/problems/subsets-ii/description/
 */
public class LC90_SubsetsII {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());

        return result;
    }

    // Performance at 1 ms beats 99.93%
    private void backtrack(int[] nums, int index, List<Integer> current){

        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++){

            if(i != index && nums[i-1]==nums[i]) continue;

            current.add(nums[i]);

            backtrack(nums, i+1, current);

            current.remove(current.size() - 1);
        }
    }

    // Performance at 8ms beats 5.42%
    private void backtrackNonOptimised(int[] nums, int index, List<Integer> current){

        Collections.sort(current);

        if(!result.contains(current))result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++){

            current.add(nums[i]);

            backtrack(nums, i+1, current);

            current.remove(current.size() - 1);
        }
    }
}
