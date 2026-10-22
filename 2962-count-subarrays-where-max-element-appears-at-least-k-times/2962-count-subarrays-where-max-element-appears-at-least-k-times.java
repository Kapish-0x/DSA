class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxEle = nums[0];
        for(int x : nums) {
            if(x > maxEle) {
                maxEle = x;
            }
        }
        int n = nums.length;
        int i = 0, found = 0;
        long res = 0;
        for(int j = 0; j < n; ++j) {
            if(nums[j] == maxEle) found++;
            while(found >= k) {
                res += n - j;
                if(nums[i] == maxEle) found--;
                i++;
            }
        }
        return res;
    }
}