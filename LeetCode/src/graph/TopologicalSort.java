package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

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
