//TC --> O(N)
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int total = set.size();
        int[] count = new int[2001];   // nums[i] <= 2000
        int distinct = 0, res = 0, i = 0;
        for (int j = 0; j < n; j++) {
            if (count[nums[j]]++ == 0) distinct++;
            while (distinct == total) {
                res += n - j;
                if (--count[nums[i]] == 0) distinct--;
                i++;
            }
        }
        return res;
    }
}