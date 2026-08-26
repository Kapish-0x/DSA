class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (hoursNeeded(piles, mid) <= h) {
                right = mid;       // mid works, try slower (smaller k)
            } else {
                left = mid + 1;    // mid too slow, need faster
            }
        }
        
        return left;
    }
    
    private long hoursNeeded(int[] piles, int k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;  // ceiling division
        }
        return hours;
    }
}