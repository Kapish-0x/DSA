class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long windowSum = 0;
        long maxSum = 0;
        int left = 0;
        for(int right = 0; right < nums.length; ++right) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            windowSum += nums[right];
            if(right - left + 1 > k) {
                int leftVal = nums[left];
                freq.put(leftVal, freq.get(leftVal) - 1);
                if(freq.get(leftVal) == 0) {
                    freq.remove(leftVal);
                }
                windowSum -= leftVal;
                left++;
            }
            if(right - left + 1 == k && freq.size() == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }
        return maxSum;
    }
}