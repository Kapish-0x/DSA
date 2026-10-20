//TC -> O(N)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0]; //handles the edge case
        for(int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i]; //finding prefix sum
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0; i < n; ++i) {
            int need = prefixSum[i] - k;
            if(map.containsKey(need)) {
                count += map.get(need);
            }
            map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
        }
        return count;
    }
}