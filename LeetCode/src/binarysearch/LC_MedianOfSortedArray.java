package binarysearch;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class LC_MedianOfSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

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
