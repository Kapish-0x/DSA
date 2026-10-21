//TC -> O(K)
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int sum = 0;
        for(int i = 0; i < k; ++i) {
            sum += cardPoints[i];
        }
        int max = sum;
        for(int i = 0; i < k; ++i) {
            sum -= cardPoints[k - 1 - i]; //remove left card
            sum += cardPoints[n - 1 - i]; //take right card
            max = Math.max(max, sum);
        }
        return max;
    }
}