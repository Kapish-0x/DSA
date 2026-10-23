class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int lastBad = -1, lastMin = -1, lastMax = -1;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < minK || nums[j] > maxK) lastBad = j;
            if (nums[j] == minK) lastMin = j;
            if (nums[j] == maxK) lastMax = j;

            res += Math.max(0, Math.min(lastMin, lastMax) - lastBad);
        }
        return res;
    }
}