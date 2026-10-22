class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;

        // Step 1: find the distinct elements of the whole array
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int total = set.size();

        int res = 0;

        // Step 2: try every starting index i
        for (int i = 0; i < n; i++) {

            // count array for distinct elements, filled with 0s
            Map<Integer, Integer> count = new HashMap<>();
            for (int x : set) count.put(x, 0);

            // Step 3: extend the subarray to the right
            for (int j = i; j < n; j++) {
                count.put(nums[j], count.get(nums[j]) + 1);

                // check if ALL distinct elements have count > 0
                boolean complete = true;
                for (int c : count.values()) {
                    if (c == 0) {
                        complete = false;
                        break;
                    }
                }

                if (complete) {
                    res += n - j;   // all longer subarrays from i also work
                    break;          // no need to extend j further for this i
                }
            }
        }
        return res;
    }
}