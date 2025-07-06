package matrix;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 * https://leetcode.com/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LC36_ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for(int i =0; i < board.length; i++){

            for(int j = 0; j < board[0].length; j++){

                if(board[i][j]!='.'){

                    boolean isValid = isRowValid(board,i,j);
                    isValid = isColValid(board,i,j) && isValid;
                    isValid = isBoxValid(board,i,j) && isValid;

                    if(!isValid) return false;
                }
            }
        }

        return true;
    }

    private boolean isRowValid(char[][] board, int row, int col){

        for(int j = 0; j < board.length; j++){

            if(j!= col && board[row][j] -'0' == board[row][col] - '0') return false;
        }

        return true;
    }

    private boolean isColValid(char[][] board, int row, int col){

        for(int i = 0; i < board.length; i++){

            if(i!=row && board[i][col] -'0' == board[row][col] -'0') return false;
        }

        return true;
    }

    private boolean isBoxValid(char[][] board, int row, int col){

        int offsetX = row % 3;
        int offsetY = col % 3;

        int startRow = row - offsetX;
        int startCol = col - offsetY;

        for(int i = startRow; i < startRow + 3; i++){

            for(int j = startCol; j < startCol + 3; j++){

                if(i!=row && j != col && board[i][j] - '0' == board[row][col] - '0') return false;
            }
        }

        return true;

    }
}
