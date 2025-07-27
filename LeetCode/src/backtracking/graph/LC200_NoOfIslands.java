package backtracking.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 *
 * https://leetcode.com/problems/number-of-islands/description/
 */
public class LC200_NoOfIslands {

    int noOfIslands = 0;

    private static final List<int[]> DIRECTIONS = Arrays.asList(

            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public int bfs(char[][] grid){

        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(grid[i][j]=='1'){

                    noOfIslands ++;
                    queue.add(new int[]{i,j});

                    while(!queue.isEmpty()){

                        int[] dir = queue.poll();

                        int r = dir[0];
                        int c = dir[1];

                        for(int[] d:DIRECTIONS){

                            int row = d[0] + r;
                            int col = d[1] + c;

                            if(row >= m || row <0 || col >=n || col <0 || grid[row][col] == '0') continue;

                            grid[row][col] = '0';

                            queue.add(new int[]{row,col});
                        }
                    }
                }
            }
        }

        return noOfIslands;
    }

    public int numIslands(char[][] grid) {

        return bfs(grid);
    }

    public int numIslandsdfs(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(grid[i][j]=='1'){

                    noOfIslands ++;
                    dfs(grid, i,j);
                }
            }
        }

        return noOfIslands;
    }

    public void dfs(char[][] grid, int row, int col){

        int m = grid.length;
        int n = grid[0].length;

        if(row <0 || row >=m || col < 0 || col >= n || grid[row][col]=='0') return ;

        grid[row][col] = '0';

        dfs(grid,row+1, col);
        dfs(grid, row, col+1);
        dfs(grid, row -1, col);
        dfs(grid, row, col -1);
    }
}
