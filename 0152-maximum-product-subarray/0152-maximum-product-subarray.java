class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int prefix_prod = 1;
        int suffix_prod = 1;

        int ans = nums[0];

        for(int i=0;i<n;i++){
            prefix_prod*=nums[i];
            suffix_prod*=nums[n-i-1];
            ans = Math.max(ans, Math.max(prefix_prod, suffix_prod));
            if(prefix_prod == 0) prefix_prod =1;
            if(suffix_prod == 0) suffix_prod = 1;
        }
        return ans;
    }
}