class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        
        // Map to store (prefixSum, frequency)
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Base case for subarrays starting from index 0
        
        for (int num : nums) {
            currentSum += num; // Running prefix sum
            
            int need = currentSum - k;
            if (map.containsKey(need)) {
                count += map.get(need);
            }
            
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}