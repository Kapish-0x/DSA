class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverseRight(nums, 0, n-1);
        reverseRight(nums, 0, k-1);
        reverseRight(nums, k, n-1);
    }
    public void reverseRight(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}