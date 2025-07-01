package matrix;

public class Search2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length==1 && matrix[0].length == 1) return matrix[0][0]==target;

        return binarySearch(matrix, target, 0,0, matrix[0].length-1);
    }

    public boolean binarySearch(int[][] matrix, int target,int row, int left, int right){

        int m = matrix.length;
        int n = matrix[0].length;

        if(row >= m ) return false;

        if(left > right) return binarySearch(matrix, target, row +1, 0, n-1);

        int mid = left + (right - left)/2;

        int candidate = matrix[row][mid];

        if(candidate == target) return true;

        if(candidate < target) return binarySearch(matrix, target, row, mid+1, right);

        else return binarySearch(matrix, target, row, left, mid-1);
    }
}
