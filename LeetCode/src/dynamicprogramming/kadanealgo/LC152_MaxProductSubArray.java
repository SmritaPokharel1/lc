package dynamicprogramming.kadanealgo;

/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * https://leetcode.com/problems/maximum-product-subarray/description/
 *
 */
public class LC152_MaxProductSubArray {

    public static int maxProduct(int[] nums) {

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for(int i = 1; i< nums.length; i++){

            int temp = maxProd;

            maxProd = Math.max(nums[i], Math.max(nums[i]*maxProd, nums[i] * minProd));
            minProd = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * minProd));
            result = Math.max(result, maxProd);
        }

        return result;
    }


    public static void main(String[] args){

        int[] nums = {-2, 3, -4};

        int result = maxProduct(nums);

        System.out.println(result);
    }
}
