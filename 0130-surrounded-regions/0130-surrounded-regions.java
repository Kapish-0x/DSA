class Solution {
    int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        // Step 1: scan the border, DFS from every 'O' found there
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isBorder = (i == 0 || i == m - 1 || j == 0 || j == n - 1);
                if (isBorder && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // Step 2: final pass -> flip remaining 'O' to 'X', flip '#' back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') return;

        board[i][j] = '#';  // mark as safe

        dfs(board, i-1, j);
        dfs(board, i+1, j);
        dfs(board, i, j-1);
        dfs(board, i, j+1);
    }
}