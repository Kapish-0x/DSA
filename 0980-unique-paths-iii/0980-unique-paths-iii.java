class Solution {
    public int uniquePathsIII(int[][] grid) {
        int emptyCount = 0;
        int startX = 0, startY = 0;
        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 0) emptyCount++;
                else if(grid[r][c] == 1) {
                    startX = r;
                    startY = c;
                }
            }
        }
        return solve(startX, startY, emptyCount, grid);
    }

    public int solve(int i, int j, int remain, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return remain == -1 ? 1 : 0;
        }

        int temp = grid[i][j];
        grid[i][j] = -1;

        int paths = solve(i + 1, j, remain - 1, grid) +
                solve(i - 1, j, remain - 1, grid) +
                solve(i, j + 1, remain - 1, grid) +
                solve(i, j - 1, remain - 1, grid);

        grid[i][j] = temp;
        return paths;
    }
}
