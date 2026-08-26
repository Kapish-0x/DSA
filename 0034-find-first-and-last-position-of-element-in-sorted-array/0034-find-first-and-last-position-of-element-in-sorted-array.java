class Solution {
    public int firstOccurrence(int[] nums , int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(nums[mid] == target) {
                ans = mid;
                end = mid - 1; //search on left side
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    public int lastOccurrence(int[] nums , int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                ans = mid;
                start = mid + 1; //search on the right side
            } else if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums , target);
        int last = lastOccurrence(nums , target);
        return new int[]{first , last};
    }   
}