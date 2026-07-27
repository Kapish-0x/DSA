class Solution {
    int count = 0;
    public void solve(int i, int n, int[] flag) {
        if(i > n) {
            count++;
            return;
        }
        for(int j = 1; j <= n; ++j) {
            if(flag[j] == 1) {
                continue;
            }
            if(j % i == 0 || i % j == 0) {
                flag[j] = 1;
                solve(i+1, n, flag);
                flag[j] = 0;
            }
        }
    }
    public int countArrangement(int n) {
        int[] flag = new int[n+1];
        solve(1, n, flag);
        return count;
    }
}