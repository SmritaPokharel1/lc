package heap;

import java.util.Arrays;


/**
 * Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.
 *
 * Example 1:
 *
 * Input: intervals = [[0,30],[5,10],[15,20]]
 * Output: false
 * Example 2:
 *
 * Input: intervals = [[7,10],[2,4]]
 * Output: true
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti < endi <= 106
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
