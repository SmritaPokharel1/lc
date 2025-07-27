package backtracking;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
 * or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 *
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 *
 * https://leetcode.com/problems/word-search/description/
 */
public class LC79_WordSearch {

    public boolean exist(char[][] board, String word) {

        for(int i = 0; i < board.length; i++){

            for(int j = 0; j < board[0].length; j++){

                boolean found = dfs(board, word, i, j, 0);

                if(found) return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int index){

        if(index == word.length()) return true;

        int m = board.length;
        int n = board[0].length;

        if(row >= m || col >= n || row < 0 || col < 0 || board[row][col] != word.charAt(index)) return false;

        char c = board[row][col];

        board[row][col] = '#';

        boolean found = dfs(board, word, row+1, col, index+1)
                || dfs(board, word, row-1, col, index +1)
                || dfs(board, word, row, col +1, index+1)
                || dfs(board, word, row, col -1, index +1);

        board[row][col] = c;

        return found;
    }
}
