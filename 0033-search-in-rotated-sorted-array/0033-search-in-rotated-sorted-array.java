//O(n)
// class Solution {
//     public int search(int[] nums, int target) {
//         for(int i = 0; i < nums.length; ++i) {
//             if(nums[i] == target) return i;
//         }
//         return -1;
//     }
// }

//Binary Search
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = right - 1;
                }
            }
        }
        return -1;
    }
}