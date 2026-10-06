class Solution {
    int m, n;
    int[][] t;
    public int solve(String s1, String s2, int i, int j) {
        if(i >= m || j >= n) return 0;
        if(t[i][j] != -1) {
            return t[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)) {
            return 1 + solve(s1, s2, i+1, j+1);
        }
        return t[i][j] = Math.max(solve(s1, s2, i+1, j), solve(s1, s2, i, j+1));
    }
    public int longestCommonSubsequence(String s1, String s2) {
        m = s1.length();
        n = s2.length();
        t = new int[m+1][n+1];
        for(int[] row : t) {
                Arrays.fill(row, -1);
            }
        return solve(s1, s2, 0, 0);
    }
}