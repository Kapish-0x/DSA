class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        List<Integer> temp = new ArrayList<Integer>();
        Arrays.sort(candidates);
        solve(candidates, 0, target, temp);
        return res;
    }
    public int solve(int[] candidates, int i, int target, List<Integer> temp) {
        if(target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if(target < 0 || i >= n) return;
        temp.add(candidates[i]);
        solve(candidates, i+1, target-candidates[i], temp);
        while(i+1 < n && candidates[i] != candidates[i+1])
        temp.remove(temp.size() - 1);
        solve(canidates, i+1, target, temp);
    }
}