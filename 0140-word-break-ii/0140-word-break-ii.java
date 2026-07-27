class Solution {
    private Map<Integer, List<String>> memo = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return solve(0, s, wordSet);
    }

    private List<String> solve(int start, String s, Set<String> wordSet) {
        // Return cached result if already computed
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        List<String> validSentences = new ArrayList<>();

        // Base case: End of string reached
        if (start == s.length()) {
            validSentences.add(""); // Base empty string to help concatenation
            return validSentences;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (wordSet.contains(word)) {
                List<String> subSentences = solve(end, s, wordSet);

                for (String sub : subSentences) {
                    if (sub.isEmpty()) {
                        validSentences.add(word);
                    } else {
                        validSentences.add(word + " " + sub);
                    }
                }
            }
        }

        // Store in cache
        memo.put(start, validSentences);
        return validSentences;
    }
}