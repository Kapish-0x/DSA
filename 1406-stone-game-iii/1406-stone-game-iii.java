class Solution {
    private int[] memo;

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE);

        // Score difference for Alice starting at index 0
        int aliceScoreDiff = getScore(0, stoneValue);

        if (aliceScoreDiff > 0) return "Alice";
        if (aliceScoreDiff < 0) return "Bob";
        return "Tie";
    }

    private int getScore(int i, int[] stoneValue) {
        int n = stoneValue.length;

        // Base case: No stones left
        if (i >= n) return 0;

        // Return cached result
        if (memo[i] != Integer.MIN_VALUE) return memo[i];

        int best = Integer.MIN_VALUE;
        int sum = 0;

        // Try taking 1, 2, or 3 stones
        for (int k = 1; k <= 3 && i + k <= n; k++) {
            sum += stoneValue[i + k - 1];
            // Current player's score minus the next player's best relative score
            best = Math.max(best, sum - getScore(i + k, stoneValue));
        }

        return memo[i] = best;
    }
}