package graph;

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
 * https://leetcode.com/problems/number-of-islands/description/
 *
 */
public class LC200_NoOfIslands {

    private static final List<int[]> DIRECTIONS = Arrays.asList(

            new int[]{1, 0},
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{0, -1}
    );

    public int numIslands(char[][] grid) {
        return bfs(grid);
    }

    public int bfs(char[][] grid){

        Queue<int[]> queue = new LinkedList<>();

        int m = grid.length;
        int n = grid[0].length;

        int noOfIslands = 0;

        for(int row = 0; row < m; row ++){

            for(int col = 0; col < n; col ++){

                if(grid[row][col] == '1'){

                    noOfIslands ++;

                    grid[row][col] = '0';

                    queue.add(new int[]{row,col});

                    while(!queue.isEmpty()){

                        int[] point = queue.remove();
                        for(int[] direction : DIRECTIONS){

                            int r = point[0] + direction[0];
                            int c = point[1] + direction[1];

                            if(r >= m || r < 0 || c >= n || c < 0 || grid[r][c] =='0') continue;

                            if(grid[r][c]=='1'){
                                grid[r][c] = '0';
                                queue.add(new int[]{r,c});
                            }
                        }
                    }
                }
            }
        }

        return noOfIslands;
    }

    public int numIslandsDfs(char[][] grid) {

        int noOfIsland = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i =0; i < m ; i++){

            for(int j = 0; j < n; j++){

                if(grid[i][j]=='1'){

                    noOfIsland++;
                    dfs(grid, i, j);
                }
            }
        }

        return noOfIsland;
    }

    public void dfs(char[][] grid, int i, int j){


        int m = grid.length;
        int n = grid[0].length;

        if( i >= m || j >= n || i < 0 || j < 0) return;

        if(grid[i][j] =='0') return;

        grid[i][j] = '0';

        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
    }
}
