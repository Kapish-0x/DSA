class Solution {
    int N, M, K;
    int MOD = 1_000_000_007;
    Integer[][][] t;
    public int solve(int idx, int searchCost, int maxSoFar) {
        if (searchCost > K) {
            return 0;
        }
        if (idx == N) {
            return searchCost == K ? 1 : 0;
        }
        if (t[idx][searchCost][maxSoFar] != null) {
            return t[idx][searchCost][maxSoFar];
        }
        long res = 0;
        for (int i = 1; i <= M; i++) {
            if (i > maxSoFar) {
                res = (res + solve(idx + 1, searchCost + 1, i)) % MOD;
            } else {
                res = (res + solve(idx + 1, searchCost, maxSoFar)) % MOD;
            }
        }
        return t[idx][searchCost][maxSoFar] = (int) res;
    }
    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        t = new Integer[n + 1][k + 1][m + 1];
        return solve(0, 0, 0);
    }
}