package heap;

import java.util.Arrays;


/**
 *
 *
 * https://leetcode.com/problems/meeting-rooms/description/
 */
public class LC252_MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {

        if(intervals.length==0) return true;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] current = intervals[0];

        for(int i = 1; i < intervals.length; i++){

            int[] next = intervals[i];

            if(current[1] > next[0]) return false;

            current = next;
        }

        return true;
    }
}
