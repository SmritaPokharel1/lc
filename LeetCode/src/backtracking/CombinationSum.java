package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtrack(candidates, target, 0,0, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, int target, int start, int sum, List<Integer> current){

        if(sum > target) return;

        if(sum == target){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i < nums.length; i++){

            current.add(nums[i]);
            sum += nums[i];
            backtrack(nums,target,i,sum,current);
            current.remove(current.size() -1);
            sum -= nums[i];
        }
    }
}
