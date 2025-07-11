package binarysearch;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * Example 3:
 *
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 *
 * https://leetcode.com/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class LC35_SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

        int start = 0;

        int end = nums.length -1;

        while(start <= end){

            int mid = start + (end - start ) / 2;

            if(nums[mid]==target) return mid;

            if(nums[mid] > target) end = mid -1;

            if(nums[mid] < target) start = mid + 1;
        }

        return start;
    }
}
