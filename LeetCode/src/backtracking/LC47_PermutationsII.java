package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * https://leetcode.com/problems/permutations-ii/description/?envType=problem-list-v2&envId=backtracking
 *
 */
public class LC47_PermutationsII {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        int n = nums.length;
        boolean[] used = new boolean[n];

        backtrack(nums, new ArrayList<>(), used);

        return result;
    }

    private void backtrack(int[] nums, List<Integer> current, boolean[] used){

        if(current.size()==nums.length){

            if(!result.contains(current)) result.add(new ArrayList<>(current));

            return;
        }

        for(int i =0; i < nums.length; i++){

            if(used[i]) continue;

            current.add(nums[i]);

            used[i] = true;

            backtrack(nums,current,used);

            current.remove(current.size() -1);

            used[i] = false;
        }
    }
}
