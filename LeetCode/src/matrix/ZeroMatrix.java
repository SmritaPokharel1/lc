package matrix;

public class ZeroMatrix {

    public void setZeroes(int[][] matrix) {

        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];

        for(int i =0; i< matrix.length; i++){

            for(int j = 0; j < matrix[0].length; j++){

                if(matrix[i][j]==0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        for(int i =0; i<rows.length; i++){

            if(rows[i])setRowsToZeroes(matrix, i);
        }

        for(int j =0; j<cols.length; j++){

            if(cols[j])setColsToZeroes(matrix, j);
        }

    }

    void setRowsToZeroes(int[][] matrix, int row){

        for(int j =0; j<matrix[0].length; j++){
            matrix[row][j] = 0;
        }
    }

    void setColsToZeroes(int[][] matrix, int col){

        for(int i = 0; i < matrix.length; i++){

            matrix[i][col] = 0;
        }
    }
}
