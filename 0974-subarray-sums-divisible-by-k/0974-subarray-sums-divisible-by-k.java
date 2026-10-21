import java.util.HashMap;

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
            
            // If we've seen this remainder before, it means the subarrays 
            // between those previous points and here are divisible by k
            count += remainderCount[rem];
            
            // Record this remainder's occurrence
            remainderCount[rem]++;
        }
        
        return count;
    }
}