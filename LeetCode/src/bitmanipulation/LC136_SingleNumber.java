package bitmanipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 *
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 *
 * https://leetcode.com/problems/single-number/description/
 *
 *
 */
public class LC136_SingleNumber {

    public int singleNumber(int[] nums){

        int a = 0;

        for(int num : nums){

            a ^= num;
        }

        return a;
    }

    public int singleNumber_(int[] nums) {

        Map<Integer,Integer> freqMap = new HashMap();

        int num = 0;

        for(int i =0; i< nums.length; i++){

            int freq = freqMap.getOrDefault(nums[i],0) +1;

            freqMap.put(nums[i], freq);
        }

        for(int i=0; i<nums.length; i++){

            int freq = freqMap.get(nums[i]);

            if(freq==1) return nums[i];
        }

        return -1;
    }

}
