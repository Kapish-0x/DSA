class Solution {
    public int numDupDigitsAtMostN(int n) {
        String s = Integer.toString(n);
        int len = s.length();
        int totalUnique = 0;

        // Step 1: count all unique-digit numbers with FEWER digits than n
        for (int len2 = 1; len2 < len; len2++) {
            totalUnique += countUniqueOfLength(len2);
        }

        // Step 2: count unique-digit numbers with SAME length as n, and <= n
        boolean[] used = new boolean[10];
        for (int i = 0; i < len; i++) {
            int digit = s.charAt(i) - '0';

            // try all smaller digits at this position
            int start = (i == 0) ? 1 : 0; // no leading zero at position 0
            for (int d = start; d < digit; d++) {
                if (used[d]) continue; // must be unique
                totalUnique += permute(9 - i, len - i - 1);
                // (9 - i) is roughly "digits remaining to choose from" -- see explanation below
            }

            if (used[digit]) {
                break; // n itself has a repeated digit at this prefix -> stop, don't count n
            }
            used[digit] = true;

            if (i == len - 1) {
                totalUnique += 1; // n itself has all unique digits, count it
            }
        }

        return n - totalUnique;
    }

    // count how many k-digit numbers (no leading zero) have all unique digits
    private int countUniqueOfLength(int k) {
        if (k == 1) return 9; // digits 1-9
        int count = 9; // first digit: 1-9
        int remaining = 9; // digits left to choose from for subsequent positions (0-9 minus first digit = 9 left)
        for (int i = 1; i < k; i++) {
            count *= remaining;
            remaining--;
        }
        return count;
    }

    // permute: choose `slots` positions from `avail` remaining digits, order matters
    private int permute(int avail, int slots) {
        int result = 1;
        for (int i = 0; i < slots; i++) {
            result *= (avail - i);
        }
        return result;
    }
}