package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
