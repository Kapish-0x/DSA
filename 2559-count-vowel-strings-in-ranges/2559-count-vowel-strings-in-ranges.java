class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n+1];
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for(int i = 0; i < n; ++i) {
            String word = words[i];
            char start = word.charAt(0);
            char end = word.charAt(word.length() - 1);
            boolean isValid = vowels.contains(start) && vowels.contains(end);
            prefix[i + 1] = prefix[i] + (isValid ? 1 : 0);
        }
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; ++i) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = prefix[r + 1] - prefix[l];
        }
        return ans;
    }
}