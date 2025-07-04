package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 * https://leetcode.com/problems/permutations
 *
 */
public class LC46_Permutation {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        boolean[] used = new boolean[nums.length];

        backtrack(nums, new ArrayList<Integer>(),used);

        return result;
    }

    public void backtrack(int[] nums, List<Integer> current, boolean[] used){

        if(current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i =0; i < nums.length; i++){

            if (used[i]) continue;

            used[i] = true;

            current.add(nums[i]);
            backtrack(nums, current,used);
            current.remove(current.size() - 1);

            used[i] = false;
        }
    }
}
