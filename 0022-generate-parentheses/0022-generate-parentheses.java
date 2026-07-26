class Solution {
    public List<String> res = new ArrayList<>();
    public void solve(int open, int close, int total, StringBuilder temp) {
        if(open + close == total) {
            res.add(temp.toString());
            return;
        }
        if(open < total/2) {
            temp.append('(');
            solve(open+1, close, total, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
        if(close < open) {
            temp.append(')');
            solve(open, close+1, total, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder temp = new StringBuilder();
        solve(0, 0, 2*n, temp);
        return res;
    }
}