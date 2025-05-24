public class AdventOfCode {

    public int solve(int[][] grid, int i, int j, char direction, int pathSum) {

        // Check for out-of-bounds or already visited
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return pathSum;
        if (grid[i][j] == -1 || grid[i][j] == 1) return pathSum;

        // Mark the current position as visited
        grid[i][j] = 1;
        pathSum++;

        // Movement logic for directions
        if (direction == 'U') {
            if (i - 1 >= 0 && grid[i - 1][j] != -1) {
                i = i - 1;
            } else {
                direction = 'R';
            }
        } else if (direction == 'R') {
            if (j + 1 < grid[0].length && grid[i][j + 1] != -1) {
                j = j + 1;
            } else {
                direction = 'D';
            }
        } else if (direction == 'D') {
            if (i + 1 < grid.length && grid[i + 1][j] != -1) {
                i = i + 1;
            } else {
                direction = 'L';
            }
        } else if (direction == 'L') {
            if (j - 1 >= 0 && grid[i][j - 1] != -1) {
                j = j - 1;
            } else {
                direction = 'U';
            }
        }

        return solve(grid, i, j, direction, pathSum);
    }
}
