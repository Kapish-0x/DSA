//RECURSION + MEMOIZATION
// class Solution {
//     int n;
//     long[][] t;
//     public long solve(int idx, int[] nums, boolean flag) {
//         if(idx >= n) return 0;
//         int isEven = flag ? 1 : 0;
//         if (t[idx][isEven] != -1) return t[idx][isEven];
//         long skip = solve(idx+1, nums, flag); //skip: sign doesnt change so true only
//         long val = nums[idx];
//         if(flag == false) {
//             val = -(val);
//         }
//         long take = solve(idx+1, nums, !flag) + val; //take: sign changes so false
//         return t[idx][isEven] = Math.max(take, skip);
//     }
//     public long maxAlternatingSum(int[] nums) {
//         n = nums.length;
//         t = new long[n + 1][2];
//         for (long[] row : t) {
//             Arrays.fill(row, -1);
//         }
//         return solve(0, nums, true);//starting from 0 which is even so true: +
//     }
// }

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] t = new long[n+1][2];
        for(int i = 1; i < n+1; ++i) {
            //Even length
            t[i][0] = Math.max(t[i-1][1] - nums[i-1], t[i-1][0]);
            //Odd length
            t[i][1] = Math.max(t[i-1][0] + nums[i-1], t[i-1][1]);
        }
        return Math.max(t[n][0], t[n][1]);
    }
}