package slidingwindow;

public class MaxConsecutiveOnes {

    public int longestOnes(int[] nums, int k) {

        int left = 0;

        int max = 0;

        int tolerance = k;

        for(int right = 0; right < nums.length; right ++){

            if(nums[right]==0) tolerance --;

            while(tolerance <0){

                if(nums[left] == 0) {
                    tolerance ++;
                }

                left ++;
            }

            max  = Math.max(max, right - left + 1);
        }

        return max;
    }
}
