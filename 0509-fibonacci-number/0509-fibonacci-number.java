//recursion+memoization (top-down)
class Solution { 
    int[] memo = new int[31];

    public Solution() {
        java.util.Arrays.fill(memo, -1);
    }
    public int fib(int n) {
        if(n <= 1) return n;
        if(memo[n] != -1) return memo[n];
        return memo[n] = fib(n-1) + fib(n-2);
    }
}