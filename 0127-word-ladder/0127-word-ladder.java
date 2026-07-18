class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord); // mark as visited by removing
        
        int level = 1; // beginWord counts as level 1
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                
                if (currWord.equals(endWord)) {
                    return level;
                }
                
                char[] wordChars = currWord.toCharArray();
                
                // try changing each letter position to every possible letter
                for (int pos = 0; pos < wordChars.length; pos++) {
                    char originalChar = wordChars[pos];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        
                        wordChars[pos] = c;
                        String newWord = new String(wordChars);
                        
                        if (wordSet.contains(newWord)) {
                            wordSet.remove(newWord); // mark visited
                            queue.offer(newWord);
                        }
                    }
                    
                    wordChars[pos] = originalChar; // restore before trying next position
                }
            }
            
            level++;
        }
        
        return 0; // endWord never reached
    }
}