package binarysearch;

public class FindMinInRotatedArray {

    int min = Integer.MAX_VALUE;

    public int findMin(int[] nums) {

        binarySearch(nums,0,nums.length-1);

        return min;
    }

    public int binarySearch(int[] nums, int left, int right){

        if(left > right) return -1;

        int mid = left + (right - left)/2;

        min = Math.min(min, nums[mid]);

        if(nums[right] < nums[mid]) return binarySearch(nums,mid+1, right);

        return binarySearch(nums,left,mid-1);
    }
}
