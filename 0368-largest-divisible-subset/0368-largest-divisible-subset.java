//Recursion
// class Solution {
//     private void solve(int idx, int[] nums, List<Integer> res, List<Integer> temp, int prev) {
//         if (idx == nums.length) {
//             if (temp.size() > res.size()) {
//                 res.clear();
//                 res.addAll(temp);
//             }
//             return;
//         }
//         // Take option (if divisible by previous element or if it's the first element)
//         if (prev == -1 || nums[idx] % prev == 0) {
//             temp.add(nums[idx]);
//             solve(idx + 1, nums, res, temp, nums[idx]);
//             temp.remove(temp.size() - 1); // Backtrack
//         }
//         // Not take option
//         solve(idx + 1, nums, res, temp, prev);
//     }

//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums); // Ensures nums[idx] % prev check works properly
//         List<Integer> res = new ArrayList<>();
//         List<Integer> temp = new ArrayList<>();
//         solve(0, nums, res, temp, -1);
//         return res;
//     }
// }

//Bottom-up
class Solution{

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if(n == 0) return new ArrayList<>();
        //Sort
        Arrays.sort(nums);
        //dp[i] = length of largest divisible subset ending at i
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        //prev[i] = index of previous element in subset ending at i
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        int maxLen = 1; // length of largest subset found so far
        int maxIndex = 0; // index where the largest subset ends
        for(int i = 1; i < n; ++i) {
            for(int j = 0; j < i; ++j) {
                if(nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        // reconstruct the largest divisible subset
        List<Integer> res = new ArrayList<>();
        int curr = maxIndex;
        while(curr != -1) {
            res.add(nums[curr]);
            curr = prev[curr];
        }
        return res;
    }
}