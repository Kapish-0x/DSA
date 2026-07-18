class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxReach = 0;
        int currentEnd = 0;
        int jumps = 0;
        
        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
            }
        }
        
        return jumps;
    }
}