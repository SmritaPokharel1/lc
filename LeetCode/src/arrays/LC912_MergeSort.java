package arrays;

/**
 *
 * Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessarily unique.
 *
 * https://leetcode.com/problems/sort-an-array/?envType=problem-list-v2&envId=merge-sort
 *
 */
public class LC912_MergeSort {

    public int[] sortArray(int[] nums) {

        mergeSort(nums);

        return nums;
    }

    public void mergeSort(int[] nums){

        int left = 0;

        int right = nums.length - 1;

        divideAndConquer(nums, left, right);
    }

    public void divideAndConquer(int[] nums, int left, int right){

        if(left >= right) return ;

        int mid = left + (right - left)/2;

        divideAndConquer(nums,left, mid);
        divideAndConquer(nums, mid+1, right);

        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right){

        int[] temp = new int[right - left + 1];

        int i = left;
        int k = 0;
        int j = mid +1;

        while(i <= mid && j <= right){

            if(nums[i] <= nums[j]){

                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i<= mid){

            temp[k++] = nums[i++];
        }

        while(j<=right){

            temp[k++] = nums[j++];
        }

        for(int index = 0; index<temp.length; index++){

            nums[left + index] = temp[index];
        }
    }
}
