package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of
 * conference rooms required.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: 2
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: 1
 *
 */
public class LC253_MeetingRoomsII {

    public int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        heap.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){

            int[] interval = intervals[i];

            if(heap.peek() <= interval[0]) heap.poll();

            heap.add(interval[1]);
        }

        return heap.size();
    }
}
