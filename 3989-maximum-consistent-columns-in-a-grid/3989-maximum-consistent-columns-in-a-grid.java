class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 1;
        
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (isCompatible(grid, i, j, limit, m)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            result = Math.max(result, dp[j]);
        }
        
        return result;
    }
    
    private boolean isCompatible(int[][] grid, int colA, int colB, int limit, int m) {
        for (int row = 0; row < m; row++) {
            if (Math.abs(grid[row][colB] - grid[row][colA]) > limit) {
                return false;
            }
        }
        return true;
    }
}