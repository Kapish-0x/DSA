import java.util.*;

class Solution {
    public List<List<Integer>> result = new ArrayList<>(); // You can change type to List<List<String>>

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(0, s, temp, result);
        return result;
    }

    private void solve(int index, String s, List<String> temp, List<List<String>> result) {
        // Base case: processed the entire string
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // Check if substring s[index...i] is a palindrome
            if (isPalindrome(s, index, i)) {
                // Choice: add the palindrome substring
                temp.add(s.substring(index, i + 1));
                
                // Explore remaining string starting from i + 1
                solve(i + 1, s, temp, result);
                
                // Backtrack: remove last added substring
                temp.remove(temp.size() - 1);
            }
        }
    }

    // Helper method to check if a substring is a palindrome
    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}