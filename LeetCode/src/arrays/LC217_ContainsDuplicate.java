package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation:
 *
 * The element 1 occurs at the indices 0 and 3.
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation:
 * All elements are distinct.
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 *
 * https://leetcode.com/problems/contains-duplicate/description/
 */
public class LC217_ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap();

        for(int num:nums){

            int freq = freqMap.getOrDefault(num, 0) +1;

            if(freq>1) return true;

            freqMap.put(num, freq);
        }

        return false;
    }
}
