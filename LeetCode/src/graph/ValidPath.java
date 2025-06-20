package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidPath {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == 0 && destination == 0) return true;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < edges.length ; i++){

            int[] edge = edges[i];

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        queue.add(source);

        while(!queue.isEmpty()){

            int node = queue.poll();

            if(node == destination) return true;

            for(int child : graph.get(node)){

                if(!visited[child]){

                    visited[child] = true;
                    queue.add(child);
                }
            }
        }

        return false;

    }
}
