class Solution {
    private static final int MOD = 1000000007;
    private Integer[][][] memo;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new Integer[m][n][maxMove + 1];
        return solve(startRow, startColumn, maxMove, m, n);
    }

    private int solve(int r, int c, int movesLeft, int m, int n) {
        // Base Case 1: Out of bounds! (Path found)
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 1;
        }

        // Base Case 2: Ran out of moves while inside the grid
        if (movesLeft == 0) {
            return 0;
        }

        // Return cached result if already calculated
        if (memo[r][c][movesLeft] != null) {
            return memo[r][c][movesLeft];
        }

        long paths = 0;

        // Try all 4 directions
        paths = (paths + solve(r + 1, c, movesLeft - 1, m, n)) % MOD; // Down
        paths = (paths + solve(r - 1, c, movesLeft - 1, m, n)) % MOD; // Up
        paths = (paths + solve(r, c + 1, movesLeft - 1, m, n)) % MOD; // Right
        paths = (paths + solve(r, c - 1, movesLeft - 1, m, n)) % MOD; // Left

        return memo[r][c][movesLeft] = (int) paths;
    }
}