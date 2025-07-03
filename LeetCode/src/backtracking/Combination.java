package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {

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
