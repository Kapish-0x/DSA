class Solution {
    Boolean[][] memo;
    public boolean solve(int i, int target, int[] nums) {
        if(i >= nums.length || target < 0) {
            return false;
        }
        if(target == 0) {
            return true;
        }
        if (memo[i][target] != null) {
            return memo[i][target];
        }
        boolean pick = solve(i+1, target-nums[i], nums);
        boolean leave = solve(i+1, target, nums);
        return memo[i][target] = pick || leave;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i: nums) {
            totalSum += i;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int target = totalSum/2;
        memo = new Boolean[nums.length][target + 1];
        return solve(0, target, nums);
    }
}