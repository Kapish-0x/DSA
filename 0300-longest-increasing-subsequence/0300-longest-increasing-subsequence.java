//Recursion + Memoization (Top-Down)
class Solution {
    int n;
    int[][] t;
    public int solve(int[] nums, int idx, int prev) {
        if(idx >= n) return 0;
        if(t[idx][prev+1] != -1) {
            return t[idx][prev+1];
        }
        int take = 0;
        if(prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + solve(nums, idx+1, idx);
        } 
        int skip = solve(nums, idx+1, prev);
        return t[idx][prev + 1] = Math.max(take, skip);
    } 
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        t = new int[n][n+1];
        for(int[] row: t) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, -1);
    }
}