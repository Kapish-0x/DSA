class Solution {
    public int fib(int n) {
        if(n < 2) {
            return n;
        }
        int res = fib(n-1)+fib(n-2);
        return res;
    }
}