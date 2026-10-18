//TC -> O(N) SC -> O(1)
class Solution {
    public int compareVersion(String v1, String v2) {
        int i = 0, j = 0;
        int n1 = v1.length(), n2 = v2.length();
        while(i < n1 || j < n2) {
            int num1 = 0;
            while(i < n1 && v1.charAt(i) != '.') {
                num1 = num1 * 10 + (v1.charAt(i) - '0');
                i++;
            }
            int num2 = 0;
            while(j < n2 && v2.charAt(j) != '.') {
                num2 = num2 * 10 + (v2.charAt(j) - '0');
                j++;
            }
            if(num1 < num2) return -1;
            if(num1 > num2) return 1;
            i++;
            j++;
        }
        return 0;
    }
}