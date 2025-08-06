package graph;

import java.util.PriorityQueue;

/**
 * You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).
 *
 * It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.
 *
 * You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.
 *
 * Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[0,2],[1,3]]
 * Output: 3
 * Explanation:
 * At time 0, you are in grid location (0, 0).
 * You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
 * You cannot reach point (1, 1) until time 3.
 * When the depth of water is 3, we can swim anywhere inside the grid.
 *
 * https://leetcode.com/problems/swim-in-rising-water/description/
 */
public class LC778_SwimInWater {

    public int swimInWater(int[][] grid) {

        PriorityQueue<int[]> minheap = new PriorityQueue<int[]>((a, b)->a[0]-b[0]);

        int m = grid.length;
        int n = grid[0].length;

        int[][] directions ={{-1,0},{1,0},{0,-1},{0,1}};

        minheap.add(new int[]{grid[0][0],0,0});

        boolean[][] visited = new boolean[m][n];

        while(!minheap.isEmpty()){

            int[] current = minheap.poll();

            int elevation = current[0];
            int row = current[1];
            int col = current[2];

            if(row == m-1 && col == n-1) return elevation;

            visited[row][col] = true;

            for(int[] direction : directions){

                int newR = direction[0] + row;
                int newC = direction[1] + col;

                if(newR >= m || newR < 0 || newC >= n || newC < 0 || visited[newR][newC]) continue;

                minheap.add(new int[]{Math.max(elevation, grid[newR][newC]),newR, newC});
            }
        }

        return -1;
    }
}
