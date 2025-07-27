package arrays;

import java.util.*;

public class LC15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer,Integer> map = getMap(nums);

        Set<List<Integer>> result = new HashSet<>();

        for(int i = 0; i < nums.length; i++){

            for(int j = 0; j < nums.length; j++){

                if(i==j) continue;

                int sum = nums[i] + nums[j];

                if(map.containsKey(-sum)){

                    int k = map.get(-sum);

                    if(k==i || k == j) continue;

                    List<Integer> temp = new ArrayList<>();

                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    Collections.sort(temp);

                    result.add(temp);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private Map<Integer, Integer> getMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i); // value -> index
        }
        return map;
    }
}
