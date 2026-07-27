class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = Integer.toString(n);
        int len = s.length();
        int base = digits.length;
        int ans = 0;

        // Step 1: numbers with fewer digits than n -> all free
        for (int k = 1; k < len; k++) {
            ans += Math.pow(base, k);
        }

        // Step 2: numbers with same digit-length as n, staying <= n
        for (int i = 0; i < len; i++) {
            char curr = s.charAt(i);
            boolean found = false;

            for (String d : digits) {
                char dc = d.charAt(0);
                if (dc < curr) {
                    ans += Math.pow(base, len - i - 1);
                } else if (dc == curr) {
                    found = true;
                }
            }

            if (!found) {
                return ans; // can't match this position exactly, stop
            }
        }

        // matched all positions exactly -> n itself is achievable
        return ans + 1;
    }
}