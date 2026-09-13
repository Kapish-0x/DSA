//Brute Force (O(n^2))
// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int maxPro = 0;
//         for(int i = 0; i < n; i++) {
//             for(int j = i + 1; j < n; j++) {
//                 int currProfit = prices[j] - prices[i];
//                 if(currProfit > maxPro) {
//                     maxPro = currProfit;
//                 }
//             }
//         }
//         return maxPro;
//     }
// }



//Optimized 
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i : prices) {
            if(i < minPrice) {
                minPrice = i;
            } else if(i - minPrice > maxProfit) {
                maxProfit = i - minPrice;
            }
        }
        return maxProfit;
    }
}