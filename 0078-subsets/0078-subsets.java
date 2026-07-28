class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    int n;
    public void solve(int[] nums, int i, List<Integer> temp) {
        if( i == n) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(nums, i+1, temp);
        temp.remove(temp.size() - 1);
        solve(nums, i+1, temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return res;
    }
}