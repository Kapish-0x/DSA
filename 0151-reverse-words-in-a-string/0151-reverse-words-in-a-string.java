class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0) {
            //skip spaces
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if(i < 0) {
                break;
            }
            //if we are at the last letter of that word
            int j = i; // j at the end of the word
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if(result.length() > 0) {
                result.append(" "); //to add space bw words
            }
            result.append(s.substring(i+1, j+1));
        }
        return result.toString();
    }
}