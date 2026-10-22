import java.util.HashMap;

class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, Integer> lastSeen = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        
        for (int j = 0; j < cards.length; j++) {
            if (lastSeen.containsKey(cards[j])) {
                int currentLen = j - lastSeen.get(cards[j]) + 1;
                minLen = Math.min(minLen, currentLen);
            }
            lastSeen.put(cards[j], j);
        }
        
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}