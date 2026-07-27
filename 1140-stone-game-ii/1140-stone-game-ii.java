class Solution {
    int[][] memo;
    int[] suffixSum;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        memo = new int[n][n + 1]; // M won't meaningfully exceed n
        for (int[] row : memo) Arrays.fill(row, -1);

        return solve(0, 1);
    }

    private int solve(int i, int M) {
        if (i >= n) {
            return 0;
        }

        // if we can take everything remaining, do it
        if (i + 2 * M >= n) {
            return suffixSum[i];
        }

        if (memo[i][M] != -1) {
            return memo[i][M];
        }

        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            if (i + X > n) break;
            int newM = Math.max(M, X);
            int take = suffixSum[i] - solve(i + X, newM);
            best = Math.max(best, take);
        }

        memo[i][M] = best;
        return best;
    }
}