package backtracking.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 *
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
 *
 *
 *
 * Example 1:
 *
 * Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 *
 * Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 *
 * https://leetcode.com/problems/surrounded-regions/description/
 *
 */
public class LC130_SurroundedRegions {
    public void solvebfs(char[][] board) {
        bfs(board);
    }

    public void solvedfs(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'E') board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {

        int m = board.length;
        int n = board[0].length;

        if (i >= m || j >= n || i < 0 || j < 0 || board[i][j] != 'O') return;

        board[i][j] = 'E';

        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
    }

    public void bfs(char[][] board) {

        int[][] directions = {
                {1, 0},
                {0, 1},
                {0, -1},
                {-1, 0}
        };

        int m = board.length;
        int n = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') queue.add(new int[]{i, 0});
            if (board[i][n - 1] == 'O') queue.add(new int[]{i, n - 1});
        }

        for (int j = 0; j < n; j++) {

            if (board[0][j] == 'O') queue.add(new int[]{0, j});
            if (board[m - 1][j] == 'O') queue.add(new int[]{m - 1, j});
        }

        while (!queue.isEmpty()) {

            int[] point = queue.poll();

            int row = point[0];
            int col = point[1];

            board[row][col] = 'e';

            for (int[] direction : directions) {

                int r = row + direction[0];
                int c = col + direction[1];

                if (r >= m || r < 0 || c >= n || c < 0 || board[r][c] != 'O') continue;

                board[r][c] = 'e';

                queue.add(new int[]{r, c});
            }
        }

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'e') board[i][j] = 'O';
            }
        }
    }
}
