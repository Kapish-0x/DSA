class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // Find the maximum value in nums to size our array perfectly (or use 100001)
        int maxVal = 0;
        for (int x : nums) {
            if (x > maxVal) maxVal = x;
        }

        // Direct-mapped frequency array (replaces the HashMap)
        int[] freq = new int[maxVal + 1];

        long sum = 0;
        long res = 0;
        int distinctCount = 0;

        // Base window: first k elements
        for (int i = 0; i < k; i++) {
            int in = nums[i];
            sum += in;
            if (freq[in] == 0) {
                distinctCount++; // New unique element found
            }
            freq[in]++;
        }

        if (distinctCount == k) {
            res = sum;
        }

        // Slide the window across nums
        for (int j = k; j < nums.length; j++) {
            int in = nums[j];
            int out = nums[j - k];

            // 1. Add 'in'
            sum += in;
            if (freq[in] == 0) {
                distinctCount++;
            }
            freq[in]++;

            // 2. Remove 'out'
            sum -= out;
            freq[out]--;
            if (freq[out] == 0) {
                distinctCount--; // Completely gone from window
            }

            // 3. If all k elements are distinct
            if (distinctCount == k) {
                res = Math.max(res, sum);
            }
        }

        return res;
    }
}