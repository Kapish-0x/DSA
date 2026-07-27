import java.util.Arrays;

class Solution {
    int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return getMinHP(0, 0, dungeon);
    }

    private int getMinHP(int i, int j, int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // Base Case: Reached Princess
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        // Out of bounds -> Return infinity so Math.min ignores this path
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (memo[i][j] != -1) return memo[i][j];

        // Minimum HP needed after leaving room (i, j)
        int minHealthNext = Math.min(
            getMinHP(i + 1, j, dungeon), 
            getMinHP(i, j + 1, dungeon)
        );

        // Minimum HP needed before entering room (i, j)
        int healthNeeded = minHealthNext - dungeon[i][j];

        // Health can never drop to 0 or lower at any point
        memo[i][j] = Math.max(1, healthNeeded);
        
        return memo[i][j];
    }
}