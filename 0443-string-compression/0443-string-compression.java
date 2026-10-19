class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;
        int n = chars.length;

        while (i < n) {
            char curr_char = chars[i];
            int count = 0;

            // Find count of consecutive repeating characters
            while (i < n && chars[i] == curr_char) {
                count++;
                i++;
            }

            // Assign the character
            chars[index++] = curr_char;

            // If count is greater than 1, convert count to characters and assign
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}