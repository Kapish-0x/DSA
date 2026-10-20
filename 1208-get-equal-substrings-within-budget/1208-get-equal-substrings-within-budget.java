//TC -> O(N)
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int i = 0, j = 0;
        int currCost = 0;
        int maxLen = 0;
        while(j < n) {      
            // Add the cost of the current character to the window
            currCost += Math.abs(s.charAt(j) - t.charAt(j));
            // If the cost exceeds maxCost, shrink the window from the left
            while(currCost > maxCost) {
                currCost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            // Update the maximum length found so far
            maxLen = Math.max(maxLen, j - i + 1);
            j++;      
        }
        return maxLen;
    }
}