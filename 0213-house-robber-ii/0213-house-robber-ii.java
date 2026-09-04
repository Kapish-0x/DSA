// class Solution {
//     int[] memo = new int[101];
//     public int solve(int[] nums, int i, int j) {
//         if(i > j) return 0;
//         if(memo[i] != -1) return memo[i];
//         int steal = nums[i] + solve(nums, i+2, j);
//         int skip = solve(nums, i+1, j);
//         return memo[i] = Math.max(steal, skip);
//     }
//     public int robLinear(int[] nums, int i, int j) {
//         Arrays.fill(memo, -1); // reset per call, since j (the boundary) changes
//         return solve(nums, i, j);
//     }
//     public int rob(int[] nums) {
//         if(nums.length == 1) return nums[0];
//         return Math.max(robLinear(nums, 0, nums.length - 2),
//         robLinear(nums, 1, nums.length - 1));
//     }
// }



class Solution {
    int[] memo = new int[101];
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        Arrays.fill(memo, -1);
        int take_0 = solve(nums, 0, n-2);
        Arrays.fill(memo, -1);
        int take_1 = solve(nums, 1, n-1);
        return Math.max(take_0, take_1);
    }
    public int solve(int[] nums, int i, int n) {
        if(i > n) return 0;
        if(memo[i] != -1) return memo[i];
        int steal = nums[i] + solve(nums, i+2, n);
        int skip = solve(nums, i+1, n);
        return memo[i] = Math.max(steal, skip);
    }
}