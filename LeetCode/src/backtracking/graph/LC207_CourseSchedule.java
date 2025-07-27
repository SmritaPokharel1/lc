package backtracking.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *
 * https://leetcode.com/problems/course-schedule/description/
 *
 */
//https://leetcode.com/problems/course-schedule/description/?envType=study-plan-v2&envId=top-interview-150
public class LC207_CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        int[] indegree = new int[numCourses];

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for(int[] prereq : prerequisites){

            int v2 = prereq[0];
            int v1 = prereq[1];

            graph.get(v1).add(v2);
            indegree[v2]++;
        }

        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        int count =0;
        while(!queue.isEmpty()){

            int v = queue.poll();

            count++;

            for(int i : graph.get(v)){

                indegree[i]--;

                if(indegree[i]==0) queue.add(i);
            }
        }

        return count == numCourses;

    }
}
