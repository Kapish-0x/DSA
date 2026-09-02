//recursion
// class Solution {
//     public int fib(int n) {
//         if( n <= 1) return n;
//         int res = fib(n-1)+fib(n-2);
//         return res;
//     }
// }

//recursion+memoization (top-down)
// class Solution { 
//     int[] memo = new int[31];
//     public Solution() {
//         Arrays.fill(memo, -1);
//     }
//     public int fib(int n) {
//         if(n <= 1) return n;
//         if(memo[n] != -1) return memo[n];
//         return memo[n] = fib(n-1) + fib(n-2);
//     }
// }

//DP (bottom-up)
class Solution {
    public int fib(int n) {
        int[] dp = new int[31];
        if( n <= 1) return n;
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; ++i) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}