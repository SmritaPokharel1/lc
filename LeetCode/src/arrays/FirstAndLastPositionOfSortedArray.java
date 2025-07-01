package arrays;

public class FirstAndLastPositionOfSortedArray {

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
