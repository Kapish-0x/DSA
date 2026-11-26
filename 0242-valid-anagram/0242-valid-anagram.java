class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();
        if(m != n) {
            return false;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}