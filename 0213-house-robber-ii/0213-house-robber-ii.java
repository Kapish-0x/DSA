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


//bottom-up constant space O(1)
// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1) return nums[0];

//         return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
//     }

//     private int robRange(int[] nums, int start, int end) {
//         int prev2 = 0;
//         int prev1 = 0;

//         for (int i = start; i <= end; i++) {
//             int current = Math.max(prev1, prev2 + nums[i]);
//             prev2 = prev1;
//             prev1 = current;
//         }

//         return prev1;
//     }
// }

//Bottom-up
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int[] t = new int[n + 1];
        t[0] = 0;
        t[1] = nums[0];
        //case1 taking the first house hence skipping the last one
        for(int i = 1; i <= n-1; ++i) {
            int skip = t[i-1];
            int steal = nums[i-1] + ((i-2 >= 0) ? t[i-2] : 0);
            t[i] = Math.max(skip, steal);
        }
        int result1 = t[n-1];
        Arrays.fill(t, 0);
        t[0] = 0;
        t[1] = 0;
        //case2 skipping the 1st house hence can take the last house 
        for(int i = 2; i <= nums.length; ++i) {
            int skip = t[i-1];
            int steal = nums[i-1] + ((i-2 >= 0) ? t[i-2] : 0);
            t[i] = Math.max(skip, steal);
        }
        int result2 = t[n];
        return Math.max(result1, result2);
    }
}