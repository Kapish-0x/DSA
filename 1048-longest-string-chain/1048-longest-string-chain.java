class Solution {
    int n;
    int[][] memo;

    boolean isPred(String prev, String curr) {
        int M = prev.length();
        int N = curr.length();
        if (M >= N || N - M != 1) {
            return false;
        } 
        int i = 0, j = 0;
        while (i < M && j < N) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == M;
    }

    public int lis(String[] words, int idx, int prev) {
        if (idx >= n) return 0;
        
        if (memo[idx][prev + 1] != -1) {
            return memo[idx][prev + 1];
        }

        int take = 0;
        if (prev == -1 || isPred(words[prev], words[idx])) {
            take = 1 + lis(words, idx + 1, idx);
        }
        int skip = lis(words, idx + 1, prev);

        return memo[idx][prev + 1] = Math.max(take, skip);
    }

    public int longestStrChain(String[] words) {
        n = words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        memo = new int[n][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return lis(words, 0, -1);
    }
}