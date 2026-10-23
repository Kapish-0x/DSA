class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int minKPosition = -1;
        int maxKPosition = -1;
        int culpritIdx = -1;
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] < minK || nums[i] > maxK) culpritIdx = i;
            if(nums[i] == minK) minKPosition = i;
            if(nums[i] == maxK) maxKPosition = i;
            long smaller = Math.min(minKPosition, maxKPosition); //picking the earlier index
            long temp = smaller - culpritIdx; //stores the no. of integers in that range if negative or 0 -> no valid subarrays if > 0 -> valid subarrays found.
            res += (temp <= 0) ? 0 : temp; //if any valid subarrays found add to res
        }
        return res;
    }
}