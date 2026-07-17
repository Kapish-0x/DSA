class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        int[] res = new int[n];

        // prefix product
        pre[0] = nums[0];
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i-1] * nums[i];
        }

        // suffix product
        suf[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            suf[i] = suf[i+1] * nums[i];
        }

        // result
        for (int i = 0; i < n; i++) {
            int left, right;
            if (i == 0) {
                left = 1;
            } else {
                left = pre[i - 1];
            }
            if (i == n - 1) {
                right = 1;
            } else {
                right = suf[i + 1];
            }
            res[i] = left * right;
        }

        return res;
    }
}