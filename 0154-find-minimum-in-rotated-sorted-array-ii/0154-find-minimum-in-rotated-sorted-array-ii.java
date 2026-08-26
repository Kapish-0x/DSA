class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                // minimum is to the right of mid
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                // minimum is at mid or to the left
                right = mid;
            } else {
                // nums[mid] == nums[right], can't decide — shrink safely
                right--;
            }
        }
        
        return nums[left];
    }
}