package binarysearch;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 */
public class LC34_FirstAndLastPositionOfSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int[] invalid = new int[]{-1,-1};

        int index = binarySearch(nums, target, 0, nums.length-1);

        if(index==-1 ) return invalid;

        int right = index;
        int left = index;

        while(right<nums.length-1 && nums[right+1]==target){
            right++;
        }

        while(left >0 && nums[left-1]==target){
            left--;
        }

        return new int[]{left,right};
    }

    public int binarySearch(int[] nums, int target, int left, int right){

        if(left > right) return -1;

        int mid = left + (right - left) /2;

        if(nums[mid] == target) return mid;

        if(target > nums[mid]) return binarySearch(nums, target, mid+1, right);

        return binarySearch(nums, target, left, mid -1);
    }
}
