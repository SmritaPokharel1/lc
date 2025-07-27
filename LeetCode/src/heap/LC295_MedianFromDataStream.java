package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 * Input
 * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
 * [[], [1], [2], [], [3], []]
 * Output
 * [null, null, null, 1.5, null, 2.0]
 *
 * Explanation
 * MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1);    // arr = [1]
 * medianFinder.addNum(2);    // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3);    // arr[1, 2, 3]
 * medianFinder.findMedian(); // return 2.0
 *
 *
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 */
public class LC295_MedianFromDataStream {

    private PriorityQueue<Integer> min;

    private PriorityQueue<Integer> max;

    public LC295_MedianFromDataStream() {

        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {

        max.add(num);
        min.add(max.poll());

        if(min.size() > max.size()) max.add(min.poll());
    }

    public double findMedian() {

        if(max.size() == min.size()) return (min.peek() + max.peek()) / 2.00;

        return max.peek();
    }
}
