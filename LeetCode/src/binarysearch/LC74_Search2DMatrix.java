package binarysearch;

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 *
 * https://leetcode.com/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-interview-150
 *
 */
public class LC74_Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length==1 && matrix[0].length == 1) return matrix[0][0]==target;

        return binarySearchWithRecursion(matrix, target, 0,0, matrix[0].length-1);
    }

    public boolean binarySearchWithRecursion(int[][] matrix, int target,int row, int left, int right){

        int m = matrix.length;
        int n = matrix[0].length;

        if(row >= m ) return false;

        if(left > right) return binarySearchWithRecursion(matrix, target, row +1, 0, n-1);

        int mid = left + (right - left)/2;

        int candidate = matrix[row][mid];

        if(candidate == target) return true;

        if(candidate < target) return binarySearchWithRecursion(matrix, target, row, mid+1, right);

        else return binarySearchWithRecursion(matrix, target, row, left, mid-1);

    }

    private boolean binarySearch(int[][] matrix, int target){

        if(matrix.length == 1 && matrix[0].length==1 && matrix[0][0]==target) return true;

        if(matrix.length == 1 && matrix[0].length==1 && matrix[0][0] != target) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0;
        int right = n-1;

        int curRow = 0;

        while(left <= right && curRow < m){

            int mid = left + (right - left)/2;

            if(matrix[curRow][mid]==target) return true;

            if(matrix[curRow][left]==target || matrix[curRow][right]==target) return true;

            if(matrix[curRow][right] < target){

                curRow++;
                left = 0;
                right = n-1;

            }else if(matrix[curRow][mid] < target){

                left = mid+1;
            }else{

                right = mid -1;
            }
        }

        return false;
    }
}
