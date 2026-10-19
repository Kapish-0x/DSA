class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0) {
            //skip spaces
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            if(i < 0) {
                break;
            }
            int j = i; //last letter of that word
            while(i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if(res.length() > 0) {
                res.append(" "); //to add a space bw prev and new word
            }
            res.append(s.substring(i+1, j+1));
        }
        return res.toString();
    }
}