//O(n^2)
// class Solution {
//     public int numSubarrayProductLessThanK(int[] nums, int k) {
//         if (k <= 1) return 0;
//         int n = nums.length;
//         int count = 0;
//         for (int i = 0; i < n; ++i) {
//             long prod = 1L; // Initialize product for the subarray starting at i
//             for (int j = i; j < n; ++j) {
//                 prod *= nums[j]; // Extend the window to include nums[j]
                
//                 if (prod < k) {
//                     count++;
//                 } else {
//                     break; // Since numbers are positive, once prod >= k, longer subarrays will also be >= k
//                 }
//             }
//         }
        
//         return count;
//     }
// }

//O(n)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) {
            return 0;
        }
        int left =0;
        int product = 1;
        int count =0;
        for(int right =0 ; right<nums.length;right++){
            product *=nums[right];

            while(product>=k){
                product /= nums[left];
                left++;
            }
            count+=right-left+1;
        }
        return count;
    }
}