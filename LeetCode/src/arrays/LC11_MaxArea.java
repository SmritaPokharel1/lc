package arrays;

/*
* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
  Find two lines that together with the x-axis form a container, such that the container contains the most water.
  Return the maximum amount of water a container can store.
  Notice that you may not slant the container.
* */
//https://leetcode.com/problems/container-with-most-water/description/
public class LC11_MaxArea {

    public int maxArea(int[] height){

        int left = 0;
        int right = height.length - 1;

        int max = 0;

        while(left < right){

            int minHeight = Math.min(height[left], height[right]);

            int area = minHeight * (right - left);

            max = Math.max(max, area);

            if(height[left]<height[right]){
                left ++;
            }else{
                right --;
            }
        }

        return max;
    }
}
