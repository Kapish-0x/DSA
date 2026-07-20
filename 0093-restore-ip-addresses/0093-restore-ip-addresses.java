class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12) {
            return result;
        }
        solve(0, 0, "", s, result);
        return result;
    }
    private void solve(int idx, int dots, String curr, String s, List<String> result) {
        if( dots == 4 ) {
            if(idx == s.length()) {
                result.add(curr.substring(0, curr.length() - 1));
            }
            return;
        }
        for(int len = 1; len <= 3; len++) {
            if(idx + len > s.length()) break;
            String segment = s.substring(idx, idx + len);
            if ((segment.length() > 1 && segment.charAt(0) == '0') || Integer.parseInt(segment) > 255) {
                return;
            }
            solve(idx + len, dots + 1, curr + segment + ".", s, result);
        }
    }
}