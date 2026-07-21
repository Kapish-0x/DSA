class Solution {
    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        // Put dictionary words in a HashSet for O(1) fast lookup
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // memo[i] stores whether s[i...end] can be broken into valid words
        memo = new Boolean[s.length()];
        
        return solve(0, s, wordSet);
    }

    private boolean solve(int index, String s, Set<String> wordSet) {
        // Base Case: We successfully chopped the entire string!
        if (index == s.length()) {
            return true;
        }

        // Return cached result if we already tried this index
        if (memo[index] != null) {
            return memo[index];
        }

        // Try every possible slice starting at 'index'
        for (int end = index + 1; end <= s.length(); end++) {
            String prefix = s.substring(index, end);

            // If current slice is valid, check if the remaining suffix can also be broken
            if (wordSet.contains(prefix) && solve(end, s, wordSet)) {
                return memo[index] = true;
            }
        }

        // None of the slices starting at 'index' worked out
        return memo[index] = false;
    }
}