// //Recursion + memo (top-down)
// class Solution {
//     int[] memo = new int[101];
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if(n == 1) return nums[0];
//         Arrays.fill(memo, -1);
//         int take_0 = solve(nums, 0, n-2);
//         Arrays.fill(memo, -1);
//         int take_1 = solve(nums, 1, n-1);
//         return Math.max(take_0, take_1);
//     }
//     public int solve(int[] nums, int i, int n) {
//         if(i > n) return 0;
//         if(memo[i] != -1) return memo[i];
//         int steal = nums[i] + solve(nums, i+2, n);
//         int skip = solve(nums, i+1, n);
//         return memo[i] = Math.max(steal, skip);
//     }
// }



class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = 0;

        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}