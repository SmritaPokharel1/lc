package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

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

}
