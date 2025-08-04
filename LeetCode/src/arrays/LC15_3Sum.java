package arrays;

import java.util.*;

/**
 * Given an array of integers arr, return all unique triplets [arr[i], arr[j], arr[k]] such that i ≠ j, i ≠ k, and j ≠ k, and the sum of the three numbers is zero.
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input:
 * arr = [-2, 0, 2, 1, -1, -1]
 * Output: [[-2, 0, 2], [-1, 0, 1], [-2, 1, 1]]
 * Explanation:
 * Valid triplets that sum to zero:
 *
 * (-2) + 0 + 2 = 0
 *
 * (-1) + 0 + 1 = 0
 *
 * (-2) + 1 + 1 = 0
 * Only distinct triplets are included in the output.
 *
 * Example 2:
 *
 * Input:
 * arr = [3, -1, -2, 5]
 * Output: []
 * Explanation: No combination of three numbers adds up to zero.
 *
 * Example 3:
 *
 * Input:
 * arr = [0, 0, 0, 0]
 * Output: [[0, 0, 0]]
 * Explanation: Only one unique triplet of zeros sums to zero.
 *
 * https://leetcode.com/problems/3sum/description/
 */
public class LC15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> map = getMap(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (i == j) continue;

                int sum = nums[i] + nums[j];

                if (map.containsKey(-sum)) {

                    int k = map.get(-sum);

                    if (k == i || k == j) continue;

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
