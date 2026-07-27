class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Integer[][][] memo = new Integer[rows][cols][cols];
        return solve(grid, 0, 0, cols - 1, memo);
    }

    private int solve(int[][] grid, int i, int j1, int j2, Integer[][][] memo) {
        int rows = grid.length, cols = grid[0].length;

        // out of bounds check (this was buggy in your draft: `j < grid[0].length` should be `j >= grid[0].length`)
        if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols) {
            return 0;
        }

        if (memo[i][j1][j2] != null) {
            return memo[i][j1][j2];
        }

        // cherries picked at this row
        int cherries = grid[i][j1];
        if (j1 != j2) {
            cherries += grid[i][j2]; // don't double count if same cell
        }

        // if last row, no further moves
        if (i == rows - 1) {
            memo[i][j1][j2] = cherries;
            return cherries;
        }

        int best = 0;
        // try all 3x3 = 9 combinations of moves for both robots
        for (int d1 = -1; d1 <= 1; d1++) {
            for (int d2 = -1; d2 <= 1; d2++) {
                best = Math.max(best, solve(grid, i + 1, j1 + d1, j2 + d2, memo));
            }
        }

        cherries += best;
        memo[i][j1][j2] = cherries;
        return cherries;
    }
}