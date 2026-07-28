class Solution {
    int m , n;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(grid[i][j] == 1) {
                    int currentArea =  dfs(grid, i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int grid[][], int i, int j) {
        if(i <0 || i >= m ||j < 0 || j >= n || grid[i][j] != 1) return 0;
        grid[i][j] = -1;
        return 1 + dfs(grid, i-1, j)
        + dfs(grid, i+1, j)
        + dfs(grid, i, j+1)
        + dfs(grid, i, j-1);
    }
}