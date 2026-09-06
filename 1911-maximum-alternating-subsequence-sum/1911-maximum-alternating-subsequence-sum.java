class Solution {
    int n;
    long[][] t;
    public long solve(int idx, int[] nums, boolean flag) {
        if(idx >= n) return 0;
        int isEven = flag ? 1 : 0;
        if (t[idx][isEven] != -1) return t[idx][isEven];
        long skip = solve(idx+1, nums, flag); //skip: sign doesnt change so true only
        long val = nums[idx];
        if(flag == false) {
            val = -(val);
        }
        long take = solve(idx+1, nums, !flag) + val; //take: sign changes so false
        return t[idx][isEven] = Math.max(take, skip);
    }
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        t = new long[n + 1][2];
        for (long[] row : t) {
            Arrays.fill(row, -1);
        }
        return solve(0, nums, true); //starting from 0 which is even so true : +
        
    }
}