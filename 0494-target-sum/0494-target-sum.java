class Solution {
    public int solve(int i, int curr, int[] nums, int key) {
        if(i == nums.length) {
            return curr == key ? 1 : 0;
        }
        int add = solve(i+1, curr + nums[i], nums, key);
        int sub = solve(i+1, curr - nums[i], nums, key);

        return add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0, 0, nums, target);
    }
}