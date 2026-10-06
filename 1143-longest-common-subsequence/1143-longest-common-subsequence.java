// Topdown
// class Solution {
//     int m, n;
//     int[][] t;
//     public int solve(String s1, String s2, int i, int j) {
//         if(i >= m || j >= n) return 0;
//         if(t[i][j] != -1) {
//             return t[i][j];
//         }
//         if(s1.charAt(i) == s2.charAt(j)) {
//             return 1 + solve(s1, s2, i+1, j+1);
//         }
//         return t[i][j] = Math.max(solve(s1, s2, i+1, j), solve(s1, s2, i, j+1));
//     }
//     public int longestCommonSubsequence(String s1, String s2) {
//         m = s1.length();
//         n = s2.length();
//         t = new int[m+1][n+1];
//         for(int[] row : t) {
//                 Arrays.fill(row, -1);
//             }
//         return solve(s1, s2, 0, 0);
//     }
// }

//Bottom-up
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] t = new int[m+1][n+1];
        for(int row = 0; row < m+1; row++) {
            t[row][0] = 0;
        }
        for(int col = 0; col < n+1; col++) {
            t[0][col] = 0;
        }
        for(int i = 1; i < m+1; i++) {
            for(int j = 1; j < n+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    t[i][j] = 1 + t[i-1][j-1];
                } else {
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                }
            }
        }
        return t[m][n];
    }
}