class Solution {
    int[] memo = new int[101];
    public int solve(int[] nums, int i, int j) {
        if(i > j) return 0;
        if(memo[i] != -1) return memo[i];
        int steal = nums[i] + solve(nums, i+2, j);
        int skip = solve(nums, i+1, j);
        return memo[i] = Math.max(steal, skip);
    }
    public int robLinear(int[] nums, int i, int j) {
        Arrays.fill(memo, -1); // reset per call, since j (the boundary) changes
        return solve(nums, i, j);
    }
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(robLinear(nums, 0, nums.length - 2),
        robLinear(nums, 1, nums.length - 1));
    }
}