package matrix;

import java.util.ArrayList;
import java.util.List;

public class LC54_SpiralMatrix {

    List<Cell> visited = new ArrayList<>();

    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0;
        int j = 0;
        int index = 0;

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        while (index < m * n) {
            // Move right
            while (j < n && !isVisited(i, j)) {
                result.add(matrix[i][j]);
                visited.add(new Cell(i, j));
                index++;
                j++;
            }
            j--; i++;

            // Move down
            while (i < m && !isVisited(i, j)) {
                result.add(matrix[i][j]);
                visited.add(new Cell(i, j));
                index++;
                i++;
            }
            i--; j--;

            // Move left
            while (j >= 0 && !isVisited(i, j)) {
                result.add(matrix[i][j]);
                visited.add(new Cell(i, j));
                index++;
                j--;
            }
            j++; i--;

            // Move up
            while (i >= 0 && !isVisited(i, j)) {
                result.add(matrix[i][j]);
                visited.add(new Cell(i, j));
                index++;
                i--;
            }
            i++; j++;
        }

        return result;
    }

    public boolean isVisited(int i, int j) {
        for (Cell cell : visited) {
            if (cell.row == i && cell.col == j) return true;
        }
        return false;
    }
}

class Cell {
    int row;
    int col;

    public Cell(int i, int j) {
        row = i;
        col = j;
    }
}
