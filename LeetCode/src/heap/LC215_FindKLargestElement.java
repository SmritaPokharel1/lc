package heap;

import java.util.PriorityQueue;

public class LC215_FindKLargestElement {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        for(int num : nums){

            heap.add(num);

            if(heap.size() > k){

                heap.remove();
            }
        }

        return heap.peek();
    }
}
