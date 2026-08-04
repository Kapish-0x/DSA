class Solution {
    int[] t = new int[46];
    public int solve(int n) {
        if(n < 0) return 0;
        if(n == 0) return 1;
        if(t[n] != -1) return t[n];
        return t[n] = solve(n-1) + solve(n-2);
    }
    public int climbStairs(int n) {
        Arrays.fill(t, -1);
        return solve(n);
    }
}