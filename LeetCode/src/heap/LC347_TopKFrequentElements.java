package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class LC347_TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int num : nums){

            int freq = freqMap.getOrDefault(num,0) + 1;
            freqMap.put(num, freq);
        }

        //This is the tricky bit where we declare a heap which will sort the elements based on
        // their frequency. Its a min heap as in the element with least frequency comes on top of heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                (n1,n2) -> freqMap.get(n1) - freqMap.get(n2)
        );

        for(int n : freqMap.keySet()){

            heap.add(n);
            if(heap.size() > k) heap.poll();
        }

        int[] top = new int[k];

        for(int i =k-1; i >= 0; i--){

            top[i] = heap.poll();
        }

        return top;
    }
}
