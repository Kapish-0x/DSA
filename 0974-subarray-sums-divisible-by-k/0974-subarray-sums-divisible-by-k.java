// class Solution {
//     public int subarraysDivByK(int[] nums, int k) {
//         int n = nums.length;
//         int temp = 0, ans = 0;
//         int[] prefixSum = new int[n];
//         prefixSum[0] = nums[0];
//         for(int i = 1; i < n; ++i) {
//             prefixSum[i] = prefixSum[i-1] + nums[i];
//         }
//         for(int i = 0; i < n; ++i) {
//             for(int j = i; j < n; ++j) {
//                 temp = (i == 0) ? prefixSum[j] : prefixSum[j] - prefixSum[i-1];
//                 if(temp % k == 0) {
//                     ans++;
//                 }
//             }
//         }
//         return ans;
//     }
// }



class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] remainderCount = new int[k];
        remainderCount[0] = 1; // Base case: remainder 0 has occurred once initially
        int currentSum = 0;
        int count = 0;
        for (int num : nums) {
            currentSum += num;
            int rem = currentSum % k;
            // Handle negative remainders in Java
            if (rem < 0) {
                rem += k;
            }
            // If we've seen this remainder before, it means the subarrays between those previous points and here are divisible by k
            count += remainderCount[rem];
            // Record this remainder's occurrence
            remainderCount[rem]++;
        }
        return count;
    }
}


