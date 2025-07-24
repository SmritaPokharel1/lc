package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


/**
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * https://leetcode.com/problems/merge-intervals/description/
 */
public class LC56_MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][];

        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int currentStart = intervals[0][0];
        heap.add(intervals[0][1]);

        List<int[]> merged = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (heap.peek() >= start) {

                if (heap.peek() < end) {
                    heap.poll();
                    heap.add(end);
                }

                currentStart = Math.min(currentStart, start);

            } else {

                merged.add(new int[]{currentStart, heap.poll()});
                currentStart = start;
                heap.add(end);
            }
        }

        merged.add(new int[]{currentStart, heap.poll()});

        return merged.toArray(new int[merged.size()][]);
    }

    public int[][] mergeII(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        if(intervals.length <= 1 ) return intervals;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for(int[] i : intervals){

            heap.add(i);
        }

        while(!heap.isEmpty()){

            int[] current = heap.poll();

            int start = current[0];
            int end = current[1];

            while(!heap.isEmpty() && ((end >= heap.peek()[0] && end <= heap.peek()[1]) || end > heap.peek()[1] )){

                int[] next = heap.poll();
                end = Math.max(end,next[1]);
            }

            result.add(new int[]{start, end});
        }

        return result.toArray(new int[result.size()][]);
    }


}
