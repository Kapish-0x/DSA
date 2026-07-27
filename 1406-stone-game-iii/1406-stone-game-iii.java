class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;

        // build from the back, since dp[i] depends on dp[i+1], dp[i+2], dp[i+3]
        for (int i = n - 1; i >= 0; i--) {
            int best = Integer.MIN_VALUE;
            int sum = 0;
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                sum += stoneValue[i + k - 1];
                best = Math.max(best, sum - dp[i + k]);
            }
            dp[i] = best;
        }

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";
    }
}