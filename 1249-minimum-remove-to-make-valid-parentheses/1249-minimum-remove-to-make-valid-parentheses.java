class Solution {
    public String minRemoveToMakeValid(String s) {
        // Pass 1: Remove unmatched ')'
        StringBuilder firstPass = new StringBuilder();
        int openCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openCount++;
                firstPass.append(c);
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--; // Matched with an open '('
                    firstPass.append(c);
                }
                // If openCount == 0, skip this unmatched ')'
            } else {
                firstPass.append(c); // Lowercase letters
            }
        }

        // If openCount == 0, all '(' were matched!
        if (openCount == 0) {
            return firstPass.toString();
        }

        // Pass 2: Remove unmatched '(' from right to left
        StringBuilder result = new StringBuilder();
        for (int i = firstPass.length() - 1; i >= 0; i--) {
            char c = firstPass.charAt(i);
            if (c == '(' && openCount > 0) {
                openCount--; // Skip this unmatched '('
            } else {
                result.append(c);
            }
        }

        // Since we scanned right-to-left in Pass 2, reverse to fix orientation
        return result.reverse().toString();
    }
}