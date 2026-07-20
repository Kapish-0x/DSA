class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // Find an empty cell
                if (board[r][c] == '.') {
                    // Try numbers '1' through '9'
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, r, c, ch)) {
                            board[r][c] = ch; // Make choice

                            // Trust recursion to fill the rest
                            if (solve(board)) {
                                return true;
                            }

                            board[r][c] = '.'; // Backtrack
                        }
                    }
                    // Tried 1-9 and none worked? Path is invalid!
                    return false;
                }
            }
        }
        // No empty cells left — puzzle solved!
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            // Check row
            if (board[row][i] == ch) return false;
            // Check column
            if (board[i][col] == ch) return false;
            // Check 3x3 sub-box
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == ch) return false;
        }
        return true;
    }
}