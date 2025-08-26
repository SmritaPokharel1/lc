package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * Example 2:
 *
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 * https://leetcode.com/problems/next-greater-element-ii/description/
 */
public class LC503_NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {

        int[] ans = new int[nums.length];

        Arrays.fill(ans, -1);

        Map<Integer,Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<Integer>();

        for(int i =nums.length -1; i >= 0; i--){

            stack.push(nums[i]);
        }

        for(int i = nums.length - 1; i >= 0; i--){

            int num = nums[i];

            while(!stack.isEmpty() && stack.peek() <= num) stack.pop();

            if(stack.size()==0)map.put(i, -1);

            else map.put(i,stack.peek());

            stack.push(num);
        }

        for(int i = 0; i < nums.length; i++){

            ans[i] = map.get(i);
        }

        return ans;

    }
}
