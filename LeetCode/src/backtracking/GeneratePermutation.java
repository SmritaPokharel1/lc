package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutation {

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
