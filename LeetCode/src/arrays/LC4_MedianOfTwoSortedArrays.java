package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Given two sorted arrays arr1 and arr2 of lengths m and n respectively, your task is to find the median value after merging these two arrays.
 *
 * The solution must achieve a time complexity of O(log (m + n)).
 *
 * Example 1:
 *
 * Input:
 * arr1 = [5, 8], arr2 = [7]
 * Output: 7.00000
 * Explanation: After merging, the combined array becomes [5, 7, 8]. The median is 7.
 *
 * Example 2:
 *
 * Input:
 * arr1 = [2, 6], arr2 = [3, 9]
 * Output: 4.50000
 * Explanation: After merging, we get [2, 3, 6, 9]. The median is the average of 3 and 6, which is (3 + 6) / 2 = 4.5.
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class LC4_MedianOfTwoSortedArrays {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int m = nums1.length;
            int n = nums2.length;

            int p1 = 0;
            int p2 = 0;

            int[] num = new int[m+n];

            int mid = (m+n) /2;

            double[] ans = new double[2];

            Arrays.fill(ans, Integer.MIN_VALUE);

            for(int i = 0; i <= mid; i++){

                int val = 0;

                if(p1 < m && p2 < n ){

                    if(nums1[p1] <= nums2[p2]){

                        num[i] = nums1[p1];
                        p1++;
                    }else{

                        num[i] = nums2[p2];
                        p2++;
                    }

                }else if (p2< n){

                    num[i] = nums2[p2];
                    p2++;

                } else if (p1 < m){

                    num[i] = nums1[p1];
                    p1 ++;
                }

                if(i!= 0 && i == mid ){
                    ans[0] = num[i-1];
                    ans[1] = num[i];
                }

                if(i==0 && mid == 0){
                    ans[0] = num[0];
                }
            }

            if((m+n) % 2 == 0){

                return (ans[0] + ans[1]) / 2.00;
            }

            return ans[1] == Integer.MIN_VALUE ? ans[0] : ans[1];

        }

    public double findMedianSortedArraysUsingHeap(int[] nums1, int[] nums2) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        int m = nums1.length;
        int n = nums2.length;

        int p1 = 0;
        int p2 = 0;

        for(int i = 0; i < m+n; i++){

            int val = 0;

            if(p1 < m && p2 < n ){

                if(nums1[p1] <= nums2[p2]){

                    val = nums1[p1];
                    p1++;
                }else{

                    val = nums2[p2];
                    p2++;
                }

            }else if (p2< n){

                val = nums2[p2];
                p2++;
            } else if (p1 < m){

                val = nums1[p1];
                p1 ++;
            }
            maxHeap.add(val);
            minHeap.add(maxHeap.poll());

            if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }


        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();

        double result = (minHeap.poll() + maxHeap.poll()) / 2.00;

        return result;
    }

    }
