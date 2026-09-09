//Recursion + Memoization (Top-down)
// class Solution {
//     int n;
//     int[][] t;              
//     public int lis(int[][] pairs, int idx, int prev) {
//         if(idx >= n) return 0;
//         if(t[idx][prev+1] != -1) return t[idx][prev+1];
//         int take = 0;
//         if(prev == -1 || pairs[idx][0] > pairs[prev][1]) {
//             take = 1 + lis(pairs, idx+1, idx);
//         }
//         int skip = lis(pairs, idx+1, prev);
//         return t[idx][prev+1] = Math.max(take, skip);
//     }
//     public int findLongestChain(int[][] pairs) {
//         this.n = pairs.length;
//         t = new int[n][n+1];
//         for(int[] rows: t) {
//             Arrays.fill(rows, -1);
//         }
//         Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0])); //we can select in any order
//         return lis(pairs, 0, -1);
//     }
// }

class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1; 
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}