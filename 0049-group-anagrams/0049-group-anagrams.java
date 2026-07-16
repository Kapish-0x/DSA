import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ansMap = new HashMap<>();
        
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            
            String sortedKey = new String(chars);
            
            if (!ansMap.containsKey(sortedKey)) {
                ansMap.put(sortedKey, new ArrayList<>());
            }

            ansMap.get(sortedKey).add(s);
        }

        return new ArrayList<>(ansMap.values());
    }
}