package matrix;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * https://leetcode.com/problems/rotate-image/description/?envType=problem-list-v2&envId=matrix
 *
 */
public class LC48_RotateMatrix {

    public void rotate(int[][] matrix) {

        transpose(matrix);

        for (int i = 0; i < matrix.length; i++) {

            reverseRow(matrix[i]);
        }
    }

    static void transpose(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                int temp = matrix[i][j];

                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    static void reverseRow(int[] row) {

        int left = 0;
        int right = row.length - 1;

        while (left < right) {

            int temp = row[left];
            row[left] = row[right];
            row[right] = temp;

            left++;
            right--;
        }
    }
}
