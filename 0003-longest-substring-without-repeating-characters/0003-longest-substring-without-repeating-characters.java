class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;
        for(int i = 0; i < s.length(); ++i) {
            char curr = s.charAt(i);
            while(set.contains(curr)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(curr);
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}