class Solution {
    private int[][] memo;

    public int numDistinct(String s, String t) {
        // Quick optimization: s must be at least as long as t
        if (s.length() < t.length()) return 0;

        memo = new int[s.length()][t.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, s, t);
    }

    private int solve(int i, int j, String s, String t) {
        // Base Case 1: Target t is fully matched!
        if (j == t.length()) {
            return 1;
        }

        // Base Case 2: Ran out of characters in s
        if (i == s.length()) {
            return 0;
        }

        // Return cached result if already computed
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int totalWays = 0;

        // If characters match, we can either match them OR skip s[i]
        if (s.charAt(i) == t.charAt(j)) {
            totalWays = solve(i + 1, j + 1, s, t) + solve(i + 1, j, s, t);
        } else {
            // Characters don't match, we must skip s[i]
            totalWays = solve(i + 1, j, s, t);
        }

        return memo[i][j] = totalWays;
    }
}