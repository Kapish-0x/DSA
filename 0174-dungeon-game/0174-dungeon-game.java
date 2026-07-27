import java.util.Arrays;

class Solution {
    public int calculateMinimumHP(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, arr, dp);
    }

    public static int dfs(int i, int j, int[][] arr, int[][] dp) {
        // Out-of-bounds -> Return MAX_VALUE so Math.min ignores this direction
        if (i >= arr.length || j >= arr[0].length) {
            return Integer.MAX_VALUE;
        }

        // Base Case: Princess room
        if (i == arr.length - 1 && j == arr[0].length - 1) {
            return arr[i][j] < 0 ? -arr[i][j] + 1 : 1;
        }

        // Return cached result
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = dfs(i + 1, j, arr, dp);
        int right = dfs(i, j + 1, arr, dp);

        int min = Math.min(down, right) - arr[i][j];

        // Need at least 1 HP to stay alive
        return dp[i][j] = min <= 0 ? 1 : min;
    }
}