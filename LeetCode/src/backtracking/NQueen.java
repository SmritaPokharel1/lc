package backtracking;

import java.util.Arrays;

public class NQueen {

    int total = 0;

    public int totalNQueens(int n) {

        int[][] chess = new int[n][n];

        for(int i = 0; i < n; i++) Arrays.fill(chess[i],0);

        backtrack(chess, 0);

        return total;
    }

    private void backtrack(int[][] chess, int row){

        if(row == chess.length){

            total ++;
            return;
        }

        for(int col =0; col < chess.length; col++){

            if(isValid(chess,row,col)){

                chess[row][col] = 1;
                backtrack(chess, row+1);
                chess[row][col] = 0;
            }
        }
    }

    private boolean isValid(int[][] chess, int row, int col){

        for(int i = 0; i < row; i++){

            if(chess[i][col] == 1) return false;
        }

        //check upper diagonal towards left
        for(int i = row-1, j = col -1; i >=0 && j >= 0; i--, j--){

            if(chess[i][j] == 1) return false;
        }

        //check lower diagonal towards right
        for(int i = row -1, j = col +1; i >=0 && j < chess.length; i--, j++){

            if(chess[i][j] == 1) return false;
        }

        return true;
    }
}
