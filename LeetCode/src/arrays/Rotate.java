package arrays;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
public class Rotate {

    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            map.put(i, nums[i]);
        }

        for(int i =0; i < nums.length; i++){

            int index = (i + k) % nums.length;

            nums[index] = map.get(i);
        }


    }
}
