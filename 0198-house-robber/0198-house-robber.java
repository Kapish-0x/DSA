//Memoization
class Solution {
    int[] memo = new int[101];
    public int rob(int[] nums) {
        Arrays.fill(memo, -1);
        return solve(nums, 0);
    }
    public int solve(int[] nums, int i) {
        if(i >= nums.length) return 0;
        if(memo[i] != -1) return memo[i];
        int steal = nums[i] + solve(nums, i+2);
        int skip = solve(nums, i+1);
        return memo[i] = Math.max(steal, skip);
    }
}


//Bottom-Up
// class Solution {
//     public int rob(int[] nums) {
//         int[] arr = new int[nums.length + 1];
//         if(nums.length == 1) return nums[0];
//         arr[0] = 0;
//         arr[1] = nums[0];
//         for(int i = 2; i <= nums.length; ++i) {
//             int steal = nums[i-1] + arr[i-2];
//             int skip = arr[i-1];
//             arr[i] = Math.max(steal , skip);
//         }
//         return arr[nums.length];
//     }
// }