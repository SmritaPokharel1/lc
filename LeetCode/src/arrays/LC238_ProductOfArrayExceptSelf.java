package arrays;

import java.util.Arrays;

public class LC238_ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] left = new int[n];

        int[] right = new int[n];

        int[] answer = new int[n];

        Arrays.fill(left,1);

        Arrays.fill(right,1);

        for(int i = 1; i < n; i++){

            left[i] = left[i-1] * nums[i-1];
        }

        for(int i = n-2; i >= 0; i--){

            right[i] = right[i+1] * nums[i+1];
        }

        for(int i = 0; i < n; i++){

            answer[i] = left[i] * right[i];
        }

        return answer;
    }
}
