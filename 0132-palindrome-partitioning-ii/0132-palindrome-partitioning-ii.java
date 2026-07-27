class Solution {
    private int[] memo;
    private boolean[][] isPalindrome;

    public int minCut(String s) {
        int n = s.length();
        memo = new int[n];
        Arrays.fill(memo, -1);
        
        // Step 1: Precompute palindrome table in O(N^2)
        isPalindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }

        // Step 2: Run top-down DP from index 0
        return solve(0, n, s);
    }

    private int solve(int i, int n, String s) {
        // Base Case 1: End of string reached
        if (i >= n) {
            return 0;
        }

        // Base Case 2: If remaining substring s[i...n-1] is already a palindrome, 0 cuts needed!
        if (isPalindrome[i][n - 1]) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        int minCuts = Integer.MAX_VALUE;

        // Try cutting after every valid palindrome prefix s[i...j]
        for (int j = i; j < n; j++) {
            if (isPalindrome[i][j]) {
                // 1 cut + min cuts needed for the rest of the string
                int currentCuts = 1 + solve(j + 1, n, s);
                minCuts = Math.min(minCuts, currentCuts);
            }
        }

        return memo[i] = minCuts;
    }
}