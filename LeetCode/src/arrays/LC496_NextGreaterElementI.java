package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
 * Output: [-1,3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
 * - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
 * Example 2:
 *
 * Input: nums1 = [2,4], nums2 = [1,2,3,4]
 * Output: [3,-1]
 * Explanation: The next greater element for each value of nums1 is as follows:
 * - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
 * - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.
 * https://leetcode.com/problems/next-greater-element-i/description
 */
public class LC496_NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        return nextGreaterElementWithStack(nums1,nums2);

    }

    public int[] nextGreaterElementWithStack(int[] nums1, int[] nums2) {

        int n = nums2.length;

        int[] ans = new int[nums1.length];

        Map<Integer,Integer> nextGreaterElement = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        stack.push(nums2[ n -1]);
        nextGreaterElement.put(nums2[n -1],-1);

        for(int i = n - 2; i >= 0; i--){

            while(!stack.isEmpty() && stack.peek() < nums2[i]) stack.pop();

            nextGreaterElement.put(nums2[i], stack.isEmpty()?-1:stack.peek());

            stack.push(nums2[i]);
        }

        for(int i = 0 ; i < nums1.length; i ++){

            ans[i] = nextGreaterElement.get(nums1[i]);
        }


        return ans;
    }


    public int[] nextGreaterElementWithMap(int[] nums1, int[] nums2) {

        int[] ans = new int[nums1.length];

        Arrays.fill(ans,-1);

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums2.length; i++) map.put(nums2[i], i);

        for(int i = 0; i < nums1.length; i++){

            int index = map.get(nums1[i]);

            for(int j = index+1; j < nums2.length; j++){

                if(nums1[i] < nums2[j]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }

        return ans;
    }
}
