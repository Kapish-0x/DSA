class Solution {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '(') {
                open++;
            } else close++;
            if(close > open) {
                open = 0;
                close = 0;
            } else if(close == open) {
                ans = Math.max(ans, 2*open);
            }
        }
        open = 0; close = 0;
        for(int i = s.length() - 1; i >= 0; --i) {
            if(s.charAt(i) == ')') {
                close++;
            } else open++;
            if(open > close) {
                open = 0;
                close = 0;
            } else if(close == open) {
                ans = Math.max(ans, 2*open);
            }
        }
        return ans;
    }
}