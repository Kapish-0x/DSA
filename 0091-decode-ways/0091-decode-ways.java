class Solution {
    private int memo[];

    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return solve(0, s);
    }
    private int solve(int i, String s) {
        if(i == s.length()) {
            return 1;
        }
        if(s.charAt(i) == '0') {
            return 0;
        }
        if(memo[i] != -1) {
            return memo[i];
        }

        int ways = solve(i+1, s);

        if(i+1 < s.length()) {
            int twoDigits = Integer.parseInt(s.substring(i, i+2));
            if(twoDigits >= 10 && twoDigits <= 26) {
                ways += solve(i+2, s);
            }
        }
        return memo[i] = ways;
    }
}