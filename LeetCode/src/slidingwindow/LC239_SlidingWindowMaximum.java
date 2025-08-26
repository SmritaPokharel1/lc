package slidingwindow;

import java.util.PriorityQueue;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * https://leetcode.com/problems/sliding-window-maximum/description/?envType=company&envId=microsoft&favoriteSlug=microsoft-thirty-days
 */
public class LC239_SlidingWindowMaximum {

    //removing elements from heap is a really expensive operation and so need to track the index aswell
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(k==1 || nums.length==1) return nums;

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);

        int index = 0;

        int[] result = new int[nums.length - k +1];

        while(queue.size() < k){

            queue.add(new int[]{nums[index],index++});
        }

        result[index - k] = queue.peek()[0];

        while(index < nums.length){

            queue.add(new int[]{nums[index],index++});

            while(queue.peek()[1] < index -k){

                queue.poll();
            }

            result[index-k] = queue.peek()[0];
        }

        return result;
    }

    //Times out
    public int[] maxSlidingWindowUnoptimised(int[] nums, int k) {

        int[] result = new int[nums.length - k+1];

        int index = 0;

        for(int i =0; i <= nums.length-k; i++){

            int max = nums[i];

            for(int j = i; j < i+k; j++){

                max = Math.max(nums[j],max);

            }

            result[index++]= max;
        }

        return result;
    }


}
