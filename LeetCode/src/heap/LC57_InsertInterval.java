package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 * https://leetcode.com/problems/insert-interval/description/
 */
public class LC57_InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        if(intervals.length ==0) return new int[][] { newInterval };

        List<int[]> result = new ArrayList<>();

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        int start = newInterval[0];
        int end = newInterval[1];

        int[] lastSeen = new int[2];

        for(int[] i : intervals){

            heap.add(i);
        }

        while(!heap.isEmpty() && heap.peek()[0] < newInterval[0] && heap.peek()[1] < newInterval[0]){

            result.add(heap.poll());
        }

        if(!heap.isEmpty() && heap.peek()[0] < newInterval[0] ) start = heap.peek()[0];

        while(!heap.isEmpty() && (newInterval[1] >= heap.peek()[1] || newInterval[1] >= heap.peek()[0])){
            lastSeen = heap.poll();
        }

        end = Math.max(end, lastSeen[1]);

        result.add(new int[]{start,end});

        while(!heap.isEmpty()){
            result.add(heap.poll());
        }

        return result.toArray(new int[result.size()][]);
    }
}
