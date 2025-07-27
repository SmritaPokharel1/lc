package matrix;

/**
 * Given an m x n binary matrix mat, return the length of the longest line of consecutive one in the matrix.
 *
 * The line could be horizontal, vertical, diagonal, or anti-diagonal.
 *
 * Input: mat = [[0,1,1,0],[0,1,1,0],[0,0,0,1]]
 * Output: 3
 *
 * Input: mat = [[1,1,1,1],[0,1,1,0],[0,0,0,1]]
 * Output: 4
 *
 * https://leetcode.com/problems/longest-line-of-consecutive-one-in-matrix/description/
 *
 */
public class LC562_LongestLineOfConsecutiveOne {

    public int longestLine(int[][] mat) {

        int max = Integer.MIN_VALUE;

        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(mat[i][j]==1){

                    max = Math.max(max,dfs(mat,i,j,0, 1));
                    max = Math.max(max,dfs(mat,i,j, 1, 0));
                    max = Math.max(max,dfs(mat,i, j, 1,1));
                    max = Math.max(max,dfs(mat, i, j, 1, -1));

                }
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public int dfs(int[][] mat, int i , int j, int dx, int dy){

        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        while(i >=0 && j >=0 && i < m && j < n && mat[i][j] == 1){

            count ++;
            i += dx;
            j += dy;
        }

        return count;
    }
}
