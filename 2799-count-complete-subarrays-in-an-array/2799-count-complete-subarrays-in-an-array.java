class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // Step 1: Find total distinct elements in the whole array
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int totalDistinct = set.size();
        
        // Step 2: Set up the sliding window and frequency tracker
        int[] freq = new int[2001];
        int currentDistinct = 0;
        int res = 0;
        int left = 0;
        
        // Step 3: Expand the window with 'right'
        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            
            // If it's a new unique element for our current window, increment our tracker
            if (freq[val] == 0) {
                currentDistinct++;
            }
            freq[val]++;
            
            // Step 4: Shrink the window from the left as long as it's valid
            while (currentDistinct == totalDistinct) {
                // All subarrays starting from 'left' up to 'right' and extending 
                // all the way to the end of the array (nums.length) are complete!
                res += nums.length - right;
                
                // Remove the left element to try and find smaller valid windows
                int leftVal = nums[left];
                freq[leftVal]--;
                if (freq[leftVal] == 0) {
                    currentDistinct--;
                }
                left++;
            }
        }
        
        return res;
    }
}