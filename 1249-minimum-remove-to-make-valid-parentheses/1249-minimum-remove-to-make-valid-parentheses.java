class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] arr = s.toCharArray();
        int openParenthesesCount = 0;

        // First pass: mark excess closing parentheses with '*'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                openParenthesesCount++;
            } else if (arr[i] == ')') {
                if (openParenthesesCount == 0) {
                    arr[i] = '*'; // Excess ')' found
                } else {
                    openParenthesesCount--;
                }
            }
        }

        // Second pass: mark excess opening parentheses from the end
        for (int i = arr.length - 1; i >= 0; i--) {
            if (openParenthesesCount > 0 && arr[i] == '(') {
                arr[i] = '*'; // Excess '(' found
                openParenthesesCount--;
            }
        }

        // Third pass: compact valid characters in-place
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != '*') {
                arr[p++] = arr[i];
            }
        }

        return new String(arr, 0, p);
    }
}