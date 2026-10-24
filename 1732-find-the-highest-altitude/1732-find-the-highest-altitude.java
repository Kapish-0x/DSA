class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = gain[0];
        for(int i = 1; i < n; ++i) {
            prefixSum[i] = prefixSum[i-1] + gain[i];
        }
        int max = prefixSum[0];
        for(int sum : prefixSum) {
            if(sum >= max) {
                max = sum;
            }
        }
        return (max < 0) ? 0 : max;
    }
}