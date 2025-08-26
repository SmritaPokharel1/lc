package backtracking;

import java.util.ArrayList;
import java.util.List;


/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 *
 * https://leetcode.com/problems/subsets/description/
 */
public class LC78_Subsets {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(nums, 0, new ArrayList<>());

        return result;
    }

    public void backtrack(int[] nums, int index, List<Integer> current){

        result.add(new ArrayList<>(current));

        for(int i = index; i < nums.length; i++ ){

            current.add(nums[i]);
            backtrack(nums, i +1, current);
            current.remove(current.size() - 1);
        }
    }
}
