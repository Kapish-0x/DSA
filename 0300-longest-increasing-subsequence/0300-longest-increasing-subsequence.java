//Recursion + Memoization (Top-Down) n x n+1 = n^2 + 1 O(n^2)
// class Solution {
//     int n;
//     int[][] t;
//     public int solve(int[] nums, int idx, int prev) {
//         if(idx >= n) return 0;
//         if(t[idx][prev+1] != -1) {
//             return t[idx][prev+1];
//         }
//         int take = 0;
//         if(prev == -1 || nums[idx] > nums[prev]) {
//             take = 1 + solve(nums, idx+1, idx);
//         } 
//         int skip = solve(nums, idx+1, prev);
//         return t[idx][prev + 1] = Math.max(take, skip);
//     } 
//     public int lengthOfLIS(int[] nums) {
//         n = nums.length;
//         t = new int[n][n+1];
//         for(int[] row: t) {
//             Arrays.fill(row, -1);
//         }
//         return solve(nums, 0, -1);
//     }
// }

//Bottom-up O(n^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); //every element alone is a subsequence of length 1
        int maxLen = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}