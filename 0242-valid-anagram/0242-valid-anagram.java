//Brute
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int m = s.length(), n = t.length();
//         if(m != n) {
//             return false;
//         }
//         char[] sArray = s.toCharArray();
//         char[] tArray = t.toCharArray();
//         Arrays.sort(sArray);
//         Arrays.sort(tArray);
//         return Arrays.equals(sArray, tArray);
//     }
// }

//Best1
// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if(s.length() != t.length()) {
//             return false;
//         }
//         Map<Character, Integer> countS = new HashMap<>();
//         Map<Character, Integer> countT = new HashMap<>();
//         for(int i = 0; i < s.length(); ++i) {
//             countS.put(s.charAt(i), countS.getOrDefault(s.charAt(i), 0) + 1);
//             countT.put(t.charAt(i), countT.getOrDefault(t.charAt(i), 0) + 1);
//         }
//         return countS.equals(countT);
//     }
// }


//Best2
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int i : count) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
}