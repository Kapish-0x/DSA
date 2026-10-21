//TC -> O(N)
class Solution {
    public int numberOfSubstrings(String s) {
        int i = 0, res = 0;
        int n = s.length();
        int[] count = new int[3];
        for(int j = 0; j < n; ++j) {
            count[s.charAt(j) - 'a']++;
            while(count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += n - j;
                count[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return res;
    }
}