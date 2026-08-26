class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long total = 0;
        long f0 = 0;
        
        // Compute F(0) and total sum
        for (int i = 0; i < n; i++) {
            total += nums[i];
            f0 += (long) i * nums[i];
        }
        
        long maxVal = f0;
        long prev = f0;
        
        // F(k) = F(k-1) + total - n * nums[n-k]
        for (int k = 1; k < n; k++) {
            long curr = prev + total - (long) n * nums[n - k];
            maxVal = Math.max(maxVal, curr);
            prev = curr;
        }
        
        return (int) maxVal;
    }
}