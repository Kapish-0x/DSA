class Solution {
    public boolean solve(int i, int j, int index, char[][] board, String word) {
        if(index == word.length()) return true;
        if( i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = solve(i+1, j, index+1, board, word) || 
                        solve(i-1, j, index+1, board, word) ||
                        solve(i, j+1, index+1, board, word) ||
                        solve(i, j-1, index+1, board, word);
        board[i][j] = temp;
        return found;
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(board[r][c] == word.charAt(0)) {
                    if(solve(r, c, 0, board, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}