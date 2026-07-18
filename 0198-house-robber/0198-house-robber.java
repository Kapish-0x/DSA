class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int prev2 = 0;           // best up to house i-2 (before house 0, so 0)
        int prev1 = nums[0];     // best up to house 0
        
        for (int i = 1; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
    }
}