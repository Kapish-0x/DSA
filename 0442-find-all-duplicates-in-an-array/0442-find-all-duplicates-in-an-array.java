class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int idx = Math.abs(num) - 1;   // abs, since it may already be flipped
            if (nums[idx] < 0) {
                res.add(Math.abs(num));    // seen before -> duplicate
            } else {
                nums[idx] = -nums[idx];    // mark as seen
            }
        }
        return res;
    }
}