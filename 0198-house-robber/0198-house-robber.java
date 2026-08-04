class Solution {
    int memo[] = new int[101];
    public int solve(int[] nums, int i) {
        if(i >= nums.length) return 0;
        if(memo[i] != -1) return memo[i];
        int steal = nums[i] + solve(nums, i+2);
        int skip = solve(nums, i+1);
        return memo[i] = Math.max(steal, skip);
    }
    public int rob(int[] nums) {
        Arrays.fill(memo, -1);
        return solve(nums, 0);
    }
}